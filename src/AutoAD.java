import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.nio.file.Paths;
import java.nio.file.Path;

public class AutoAD {
	
	private PrintWriter archivoOut;
	private BufferedReader archivoIn;
	private String fileNameDB = "Auto.txt";
	private Path currentPath = Paths.get(System.getProperty("user.dir"));
	private Path filePath = Paths.get(currentPath.toString(), "database", fileNameDB);

	public String consultarDatos()
	  {
		
	    String datos="";
	    String str;
	    try
	    {
	        // 1. Abrir el archivo para leer los datos
	        archivoIn = new BufferedReader(new FileReader(filePath.toString()));
	        // 2. Procesar los datos
	        while(archivoIn.ready())
	        {
	          str = archivoIn.readLine();

	          datos = datos+ str +"\n";
	        }
	        // 3. Cerrar el archivo
	        archivoIn.close();
	    }
	    catch(FileNotFoundException fnfe)
	    {
	      datos = "Error: "+fnfe;
	      System.out.println("Error: "+ fnfe);
	    }
	    catch(IOException ioe)
	    {
	        datos = "Error:" +ioe;
	        System.out.println("Error: "+ioe);
	    }
	    // 4. Entregar los datos
	    return datos;
	  }
	
	public String capturar(String datos)
	  {  
	    String transaccion;
	    try
	    {
	    // 1. Abrir el archivo de datos para escribir en el
	    archivoOut = new PrintWriter (new FileWriter(filePath.toString(),true));
	    // 2. Guardar los datos en el archivo
	    archivoOut.println(datos);
	    // 3. Cerrar el archivo de datos
	    archivoOut.close();

	    transaccion = "Captura correcta de datos\n "+datos;
	    }
	    catch(IOException ioe)
	    {   transaccion = "Error:" +ioe;
	        System.out.println("Error: "+ioe);
	    }
	    // 4. Entregar resultado de la transaccion
	    return transaccion;
	  }
	
	public String consultarMarca(String marca)
	  {
	    String datos="";
	    String str, tokenMarca;
	    StringTokenizer st;
	    boolean encontrado = false;
	    try
	    {
	        // 1. Abrir archivo para leer
	        archivoIn = new BufferedReader(new FileReader(filePath.toString()));
	        // 2. Procesar el archivo y buscar el tipo de cuenta
	        while(archivoIn.ready())
	        {
	            str = archivoIn.readLine();

	            st = new StringTokenizer(str,"_");

	            tokenMarca = st.nextToken();
	            tokenMarca = st.nextToken();
	           
	             
	            if(marca.equals(tokenMarca))
	            {
	                datos = datos + str + "\n";
	                encontrado = true;
	            }
	        }

	        // 3. Cerrar el archivo
	        archivoIn.close();
	        if(encontrado == false)
	        {
	          datos = "No se localizo el Tipo de Cuenta: "+marca;
	        }
	    }
	    catch(FileNotFoundException fnfe)
	      {
	        datos = "Error: "+fnfe;
	        System.out.println("Error: "+fnfe);
	      }
	    catch(IOException ioe)
	      {
	        datos = "Error:" +ioe;
	        System.out.println("Error: "+ioe);
	      }
	    // 4. Entregar resultado de la transaccion
	    return datos;
	  }
	
	 public boolean compararClave(String clave)
	  {
		  boolean existe=false;
		  String str;
		  StringTokenizer st;
		  
		try{
			 //1. Abrir archivo para leer
			  BufferedReader read= new BufferedReader(new FileReader(filePath.toString()));
			 //2. Procesar información
			  		  
			  while(read.ready() && existe==false){
				  str=read.readLine();
				  st=new StringTokenizer(str, "_");
				  String tokenClave= st.nextToken();
				  if(clave.equals(tokenClave)){
					existe=true;  
				  }
				  
			  }
			read.close();
		}catch(Exception e){
			System.out.println("error: "+ e);
			
		}
		 
		  return existe;
	  }
	 
	 public String consultarTipo(String tipo)
	  {
	    String datos="";
	    String str, tokenTipo;
	    StringTokenizer st;
	    boolean encontrado = false;
	    try
	    {
	        // 1. Abrir archivo para leer
	        archivoIn = new BufferedReader(new FileReader(filePath.toString()));
	        // 2. Procesar el archivo y buscar el tipo de cuenta
	        while(archivoIn.ready())
	        {
	            str = archivoIn.readLine();

	            st = new StringTokenizer(str,"_");

	            tokenTipo = st.nextToken();
	            tokenTipo = st.nextToken();
	            tokenTipo = st.nextToken();
	             
	            if(tipo.equals(tokenTipo))
	            {
	                datos = datos + str + "\n";
	                encontrado = true;
	            }
	        }

	        // 3. Cerrar el archivo
	        archivoIn.close();
	        if(encontrado == false)
	        {
	          datos = "No se localizo el Tipo de Auto: "+tipo;
	        }
	    }
	    catch(FileNotFoundException fnfe)
	      {
	        datos = "Error: "+fnfe;
	        System.out.println("Error: "+fnfe);
	      }
	    catch(IOException ioe)
	      {
	        datos = "Error:" +ioe;
	        System.out.println("Error: "+ioe);
	      }
	    // 4. Entregar resultado de la transaccion
	    return datos;
	  }
	 
	  public String consultarClave(String clave)
	  {
	    String datos="";
	    String str, tokenClave;
	    StringTokenizer st;
	    boolean encontrado = false;
	    try
	    {
	        // 1. Abrir archivo para leer
	        archivoIn = new BufferedReader(new FileReader(filePath.toString()));
	        // 2. Procesar el archivo y buscar el tipo de cuenta
	       
	        while(archivoIn.ready() && encontrado==false)
	        {	
	            str = archivoIn.readLine();

	            st = new StringTokenizer(str,"_");

	            tokenClave = st.nextToken();

	            if(clave.equals(tokenClave))
	            {
	                datos = datos + str + "\n";
	                encontrado = true;
	            }
	        }
	       
	        // 3. Cerrar el archivo
	        archivoIn.close();
	        if(encontrado == false)
	        {
	          datos = "No se localizo la clave: "+clave;
	        }
	    }
	    catch(FileNotFoundException fnfe)
	      {
	        datos = "Error: "+fnfe;
	        System.out.println("Error: "+fnfe);
	      }
	    catch(IOException ioe)
	      {
	        datos = "Error:" +ioe;
	        System.out.println("Error: "+ioe);
	      }
	    // 4. Entregar resultado de la transaccion
	    return datos;
	  }
}
