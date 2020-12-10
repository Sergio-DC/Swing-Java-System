
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.nio.file.Paths;
import java.nio.file.Path;

public class LibroAD {
	private BufferedReader lectura;
	private PrintWriter escritura;
	private String transaccion="";
	private String fileNameDB = "biblioteca.txt";
	private Path currentPath = Paths.get(System.getProperty("user.dir"));
	private Path filePath = Paths.get(currentPath.toString(), "database", fileNameDB);
	
	public String capturar(String resultado){
		
		try{
			//Abrir Archivo
			escritura=new PrintWriter(new FileWriter(filePath.toString(), true));
			//Escribir en el archivo
			escritura.println(resultado);
			//cerrar archivo
			escritura.close();
			
			transaccion="Captura correcta de datos";

		}catch(Exception e){
			System.out.println("Error: "+e);
			transaccion="Error: "+e;
		}
		
		return transaccion;
		
	}
	
	public String consultar(){
		String str, datos="";
		
		try{
			lectura=new BufferedReader(new FileReader(filePath.toString()));
			while(lectura.ready()){
				str=lectura.readLine();
				datos=datos+str+"\n";
			}
			if(datos.isEmpty())	datos="No se han encontrado registros";
			lectura.close();
		}catch(Exception e){
			System.out.println("Error: "+e);
			datos="El archivo no se ha abierto correctamente";
		}
		return datos;
	}
	
	public String consultarE(String editorial){
		String str, datos="", buscar;
		StringTokenizer st;
		boolean encontrado=false;
		
		try{
			lectura=new BufferedReader(new FileReader(filePath.toString()));
			while(lectura.ready() && encontrado==false){				
				str=lectura.readLine();
				st=new StringTokenizer(str, "_");
				buscar = st.nextToken();
				buscar = st.nextToken();
				buscar = st.nextToken();
				
				if(editorial.equals(buscar)){
					encontrado=true;
					datos=str+"\n";
				}else{
					datos="Registro no  encontrado";
				
				}
				
				if(editorial.isEmpty()){
					datos="Campos Vacios";
					
				}
				
			}
			
			lectura.close();
		}catch(Exception e){
			System.out.println("Error: "+ e);
			datos="El archivo no se abrio correctamente";
		}
		return datos;
	}
	
	public String consultarT(String titulo){
		String str, datos="";
		StringTokenizer st;
		boolean encontrado=false;
		
		try{
			lectura = new BufferedReader(new FileReader(filePath.toString()));
			while(lectura.ready() && encontrado==false){
				str = lectura.readLine();
				st = new StringTokenizer(str, "_");
				datos = st.nextToken();
				datos = st.nextToken();
				
				if(datos.equals(titulo)){
					datos=str+"\n";
					encontrado=true;
				}else{
					datos="Registro no encontrado";
					
				}
				
				if(titulo.isEmpty()){
					datos="Campos vacios";
				
				}
				
			}
			lectura.close();
		}catch(Exception e){
			System.out.println("Error: "+ e);
			datos= "El archivo no se abrio correctamente";
		}
		return datos;
	}

}
