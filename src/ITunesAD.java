import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.util.Vector;
import java.nio.file.Paths;
import java.nio.file.Path;

public class ITunesAD {
	
	private BufferedReader archivoIn;
	private PrintWriter archivoOut;
	private Vector<String> vectorArtistas, vectorAlbums, vectorCanciones;
	private String fileNameDB_Artist = "Artistas01.txt";
	private String fileNameDB_Album = "Album01.txt";
	private String fileNameDB_Song = "Cancion01.txt";
	private Path currentPath = Paths.get(System.getProperty("user.dir"));
	private Path filePathArtist = Paths.get(currentPath.toString(), "database", fileNameDB_Artist);
	private	Path filePathAlbum = Paths.get(currentPath.toString(), "database", fileNameDB_Album);
	private Path filePathSong = Paths.get(currentPath.toString(), "database", fileNameDB_Song);
	
	public Vector<String> getArtist(String artist)
	{
		String str;
		try
		{
			//1. Abrir el archivo
			archivoIn = new BufferedReader(new FileReader(filePathArtist.toString()));
			
			//2. Procesar el archivo
			vectorArtistas = new Vector<String>();
			
			while(archivoIn.ready())
			{
				str=archivoIn.readLine();
				
				if(artist.equals(str))
				{
					vectorArtistas.add(str);
				}			
				
			}
			
			archivoIn.close();
			//3. Cerrar el archivo
		}
		catch(Exception e)
		{
			
		}
		
		return vectorArtistas;
	}
	
	
	public Vector<String> obtenerArtistas()
	{
		String datos="", str;
		
		try
		{
			//1. Abrir el Archivo artistas.txt
			archivoIn=new BufferedReader(new FileReader(filePathArtist.toString()));
			//2. Procesar datos
			vectorArtistas = new Vector<String>();
			while(archivoIn.ready())
			{
				str=archivoIn.readLine();
				System.out.println(str);
				//datos=datos+str+"\n";
				
				vectorArtistas.add(str);				
				
			}
			//3. Cerrar el archivo
			archivoIn.close();
		}
		catch(Exception e)
		{
			System.out.println("Error"+e);
		}
	
		
		 
		
		return vectorArtistas;
	}
	
	public Vector<String> obtenerAlbums(String artista)
	{
		String str, artist, album;
		StringTokenizer st;
		vectorAlbums = new Vector<String>();
		
		try
		{
			// 1. Abrir el archivo de album
			archivoIn = new BufferedReader(new FileReader(filePathAlbum.toString()));
			
			//2. Procesar el archivo
			while(archivoIn.ready())
			{
				str = archivoIn.readLine();
				st = new StringTokenizer(str, "_");
				artist =st.nextToken(); 
				album = st.nextToken();
				
				if(artista.equals(artist))
				{
					vectorAlbums.add(album);
				}
			}
			
			// 3. Cerrar el archivo
			archivoIn.close();
		}
		catch(Exception e)
		{
			System.out.println("Error: "+e);
		}
		
		return vectorAlbums;
	}
	
	public Vector<String> obtenerCanciones(String album)
	{
		String str, disco, cancion;
		StringTokenizer st;
		vectorCanciones = new Vector<String>();
		try
		{
		//1. Abir el archivo de canciones
		archivoIn = new BufferedReader(new FileReader(filePathSong.toString()));
		//2. Procesar el archivo
		
		while(archivoIn.ready())
		{
			str = archivoIn.readLine();
			st = new StringTokenizer(str, "_");
			disco =st.nextToken(); 
			cancion = st.nextToken();
			
			if(album.equals(disco))
			{
				vectorCanciones.add(cancion);
			}
		}
		//3. Cerrar el archivo
		archivoIn.close();
		}
		catch(Exception e)
		{
			System.out.println("Error: "+e);
		}
		
		return vectorCanciones;
	}
}
