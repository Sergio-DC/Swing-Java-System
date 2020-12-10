

import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.util.StringTokenizer;
import java.nio.file.Paths;
import java.nio.file.Path;

public class BancoAD
{
  private PrintWriter archivoOut;
  private BufferedReader archivoIn;
  private String fileNameDB = "Clientes.txt";
  private Path currentPath = Paths.get(System.getProperty("user.dir"));
  private Path filePath = Paths.get(currentPath.toString(), "database", fileNameDB);

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

    transaccion = "Captura correcta de datos "+datos+"\n";
    }
    catch(IOException ioe)
    {   transaccion = "Error:" +ioe;
        System.out.println("Error: "+ioe);
    }
    // 4. Entregar resultado de la transaccion
    return transaccion;
  }

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
  public String consultarTipo(String tipo)
  {
    String datos="";
    String str, tipoCta;
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

            tipoCta = st.nextToken();
            tipoCta = st.nextToken();
            tipoCta = st.nextToken();
             
            if(tipo.equals(tipoCta))
            {
                datos = datos + str + "\n";
                encontrado = true;
            }
        }

        // 3. Cerrar el archivo
        archivoIn.close();
        if(encontrado == false)
        {
          datos = "No se localizo el Tipo de Cuenta: "+tipo;
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

  public String consultarNoCta(String tipo)
  {
    String datos="";
    String str, tipoNoCta;
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

            tipoNoCta = st.nextToken();

            if(tipo.equals(tipoNoCta))
            {
                datos = datos + str + "\n";
                encontrado = true;
            }
        }
       
        // 3. Cerrar el archivo
        archivoIn.close();
        if(encontrado == false)
        {
          datos = "No se localizo el Numero de Cuenta: ";
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
  
  public boolean compararCuenta(String nocta)
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
			  String tokenCuenta= st.nextToken();
			  if(nocta.equals(tokenCuenta)){
				existe=true;  
			  }
			  
		  }
		read.close();
	}catch(Exception e){
		System.out.println("error: "+ e);
		
	}
	 
	  return existe;
  }
  
  /*public Borrar(){
	  
  }*/
	
}
