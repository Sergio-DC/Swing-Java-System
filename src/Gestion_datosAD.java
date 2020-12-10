import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.nio.file.Paths;
import java.nio.file.Path;

public class Gestion_datosAD 
{
	private BufferedReader leer;
	private PrintWriter escribir;
	private String fileNameDB_Artist = "Artistas01.txt";
	private String fileNameDB_Album = "Album01.txt";
	private String fileNameDB_Song = "Cancion01.txt";
	private Path currentPath = Paths.get(System.getProperty("user.dir"));
	private Path filePathArtist = Paths.get(currentPath.toString(), "database", fileNameDB_Artist);
	private Path filePathAlbum = Paths.get(currentPath.toString(), "database", fileNameDB_Album);
	private Path filePathSong = Paths.get(currentPath.toString(), "database", fileNameDB_Song);
	
	
	private boolean compararArtistas(String artista)
	{
		boolean encontrado = false;
		String cmpArtista;
		try
		{	//Abrir archivo
			leer = new BufferedReader(new FileReader(fileNameDB_Artist.toString()));
			//Procesar Archivo
			while(leer.ready() && encontrado == false)
			{
				cmpArtista = leer.readLine();
				
				if(artista.equals(cmpArtista))
				{
					encontrado = true;
				}
			}
			
			//Cerrar Archivo
			leer.close();
		}
		catch(Exception e)
		{
			System.out.println("El archivo no se encontró...");
		}
		
		return encontrado;
	}
	
	private boolean compararAlbum(String Album)
	{
		boolean encontrado = false;
		String cmpAlbum, artista, str;
		StringTokenizer st;
		try
		{	//Abrir archivo
			leer = new BufferedReader(new FileReader(fileNameDB_Album.toString()));
			//Procesar Archivo
			while(leer.ready() && encontrado == false)
			{
				str = leer.readLine();
				st = new StringTokenizer(str, "_");
				artista = st.nextToken();
				cmpAlbum = st.nextToken();
				
				if(Album.equals(cmpAlbum))
				{
					encontrado = true;
				}
			}
			
			//Cerrar Archivo
			leer.close();
		}
		catch(Exception e)
		{
			System.out.println("El archivo no se encontró...");
		}
		
		return encontrado;		
	}
	
	private boolean compararCancion(String Cancion)
	{
		boolean encontrado = false;
		String cmpCancion, Album, str;
		StringTokenizer st;
		try
		{	//Abrir archivo
			leer = new BufferedReader(new FileReader(fileNameDB_Song.toString()));
			//Procesar Archivo
			while(leer.ready() && encontrado == false)
			{
				str = leer.readLine();
				st = new StringTokenizer(str, "_");
				Album = st.nextToken();
				cmpCancion = st.nextToken();
				
				if(Cancion.equals(cmpCancion))
				{
					encontrado = true;
				}
			}
			
			//Cerrar Archivo
			leer.close();
		}
		catch(Exception e)
		{
			System.out.println("El archivo no se encontró...");
		}
		
		return encontrado;		
	}
	
	public String registrarArtistas(String Artista)
	{
		String datos="";
		try
		{
			//Abrir archivo
			escribir = new PrintWriter(new FileWriter(filePathArtist.toString(), true));
			
			//Comprobar que no exista un artista repetido
			if(compararArtistas(Artista)==true)
			{
				datos ="El artista ya existe... ";
			}
			else
			{
				//Escribir en el archivo
				escribir.println(Artista);
				datos = "Artista agregado al registro: "+Artista;
			}
					
			
			//Cerrar Archivo
			escribir.close();
			
		}
		catch(Exception e)
		{
			System.out.println("Error: "+e);
		}
		
		return datos;
	}
	
	public String registrarAlbum(String Artista, String Album)
	{
		String datos="";
		try
		{
			//Abrir el archivo
			escribir = new PrintWriter(new FileWriter(fileNameDB_Album.toString(), true));
			//Comprobar que no exista un artista repetido
			if(compararAlbum(Album)==true)
			{
				datos = "\nEl album ya existe...";  
			}
			else
			{
				//Escribir en el archivo
				escribir.println(Artista+"_"+Album);
				datos="\nAlbum agregado al registro: "+ Album;
			}
			//Cerrar el archivo
			escribir.close();
			
		}
		catch(Exception e)
		{
			System.out.println("Error: "+ e);
		}
		return datos;
	}	

	
	public String registrarCancion(String Album, String cancion)
	{
		String datos="";
		try
		{
			//Abrir el archivo
			escribir = new PrintWriter(new FileWriter(fileNameDB_Song.toString(), true));
			
			//Comprobar que no exista un artista repetido
			if(compararCancion(cancion)==true)
			{
				datos = "\nLa canción ya existe...";
			}
			else
			{
				//Escribir en el archivo
				escribir.println(Album+"_"+cancion);
				datos = "\nCanción agregada al registro: "+cancion; 
			}
			
			//Cerrar el archivo
			escribir.close();
			
		}
		catch(Exception e)
		{
			System.out.println("Error: "+ e);
		}
		return datos;
	}
	
	public String consultaArtista()
	{
		String datos="", str;
		try
		{
			//Abrir el archivo
			leer = new BufferedReader(new FileReader(filePathArtist.toString()));
			//Procesar el archivo
			while(leer.ready())
			{
				str = leer.readLine();
				datos= datos + str+"\n";
			}
			
			leer.close();
		}
		catch(Exception e)
		{
			System.out.println("Error: "+ e);
		}
		
		return datos;
	}
	
	public String consultaAlbum()
	{
		String datos="", str;
		String artista, album;
		StringTokenizer st;
		try
		{
			//Abrir el archivo
			leer = new BufferedReader(new FileReader(fileNameDB_Album.toString()));
			//Procesar el archivo
			while(leer.ready())
			{
				str = leer.readLine();
				st = new StringTokenizer(str, "_");
				artista = st.nextToken();
				album = st.nextToken();
				datos= datos + album+"\n";
			}
			
			leer.close();
		}
		catch(Exception e)
		{
			System.out.println("Error: "+ e);
		}
		
		return datos;
	}
	
	public String consultaCancion()
	{
		String datos="", str;
		String album, cancion;
		StringTokenizer st;
		try
		{
			//Abrir el archivo
			leer = new BufferedReader(new FileReader(fileNameDB_Song.toString()));
			//Procesar el archivo
			while(leer.ready())
			{
				str = leer.readLine();
				st = new StringTokenizer(str, "_");
				album = st.nextToken();
				cancion = st.nextToken();
				datos= datos + cancion+"\n";
			}
			
			leer.close();
		}
		catch(Exception e)
		{
			System.out.println("Error: "+ e);
		}
		
		return datos;
	}
	
	
	
	


}