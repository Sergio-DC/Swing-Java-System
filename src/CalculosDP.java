import javax.swing.JOptionPane;

public class CalculosDP {
	
		/*private  float obtenerGrados(String str)
		{
			String strGrados;
			float  grados=0;
			boolean numeroCorrecto=false;
			
			do
			{
				try
				{
					strGrados = JOptionPane.showInputDialog(str);
					grados = Float.parseFloat(strGrados);
					numeroCorrecto = true;
				}
				catch(NumberFormatException nfe)
				{
					System.out.println("Error: "+nfe);
				}
			} while(!numeroCorrecto);
			
			return grados;	
		}*/
		
		public static  float gc_gf(float gc)
		{
			float grados;
			
			grados = (float)9/5 * gc +32;
			
			return grados;
		}
		
		public static  float gf_gc(float gf)
		{
			float grados;
			
			grados = (float)5/9 * (gf - 32);
			
			return grados;
		}
		
		
		
		/*private  int pedirValor(String str)
	    {
	        String strValor;
	        int valor=0;
	        boolean numeroCorrecto=false;
	        
	        do
	        {
	            try
	            {
	                strValor = JOptionPane.showInputDialog(str);
	                valor = Integer.parseInt(strValor);
	                numeroCorrecto=true;
	            }
	            catch(NumberFormatException nfe)
	            {
	                System.out.println("Error: "+nfe);
	            }
	        } while(numeroCorrecto==false);
	        
	        
	        return valor;
	    }*/
		
		public static int exponencial(int b, int expo)
	    {
	        int e;
	        
	        e=1;
	        for(int i=1; i<=expo; i++)
	            e = e * b;
	        
	        return e;
	    }
	    
	    /*private void calcularExponencial()
	    {
	        String strBase, strX;
	        int base,x,y;
	        String resultado="";
	        
	        //do
	        //{
	            // 1. Obtener la Base y  X
	            base = pedirValor("Base =");
	            
	            x = pedirValor("X =");
	            
	            // 2. Calcular Y = B ^ X  
	            if(x < 0)          
	            {
	            	y = exponencial(base,-x);
	            	resultado = "Exponencial Y = "+base+" ^ "+x+" = 1/"+y;
	            	
	            }
	            else
	            {
	            	y = exponencial(base,x);
	 	          	resultado = "Exponencial Y = "+base+" ^ "+x+" = "+y;
	            }
	            
	            // 3. Desplegar resultado
	            JOptionPane.showMessageDialog(null,resultado);            
	    }*/

	    public static String factorial(int num)
	    {
	        int fac=1;
	        
	        for(int i=1; i<=num; i++)
	            fac = fac * i;
	        
	        return "El factorial es: "+fac;
	    }
	    
	    /*public  String calcularFactorial()
	    {
	        int n,f;
	        String resultado;
	        
	        // 1. Pedir No. del Factorial
	        n = pedirValor("No. del Factorial =");
	        
	        // 2. Calcular el Factorial de N y desplegar rsultado
	        if(n<0)
	        	//JOptionPane.showMessageDialog(null,"Error: No hay factoriales de numeros negativos...");
	        	return resultado="Error: No hay factoriales de numeros negativos...";
	        else
	        {
	        	f = factorial(n);
	        	//JOptionPane.showMessageDialog(null,"Factorial de "+n+" = "+f);
	        	return resultado="Factorial de "+n+" = "+f;
	        }        
	    }*/
		
		/*private  int obtenerCoeficiente(String str)
		{
			String strCoeficiente;
			int  coeficiente=0;
			boolean numeroCorrecto=false;
			
			do
			{
				try
				{
					strCoeficiente = JOptionPane.showInputDialog(str);
					coeficiente    = Integer.parseInt(strCoeficiente);
					numeroCorrecto = true;
				}
				catch(NumberFormatException nfe)
				{
					System.out.println("Error: "+nfe);
				}
			} while(!numeroCorrecto);
			
			return coeficiente;
		}*/
			
		
		public  String ecuacion(int a, int b, int c)
	    {
	        String strA, strB, strC;
	        //int a, b, c;
	        int radical;
	        float x, x1, x2;
	        String resultado="";
	        
	        // 1. Obtener coeficientes a, b, c
	        /*strA = JOptionPane.showInputDialog("Coeficiente A =");
	        strB = JOptionPane.showInputDialog("Coeficiente B =");
	        strC = JOptionPane.showInputDialog("Coeficiente C =");
	        */
	        // Convertir coeficientes de String a numero entero
	        /*a = Integer.parseInt(strA);
	        b = Integer.parseInt(strB);
	        c = Integer.parseInt(strC);
	        */
	        
	        //a = obtenerCoeficiente("Coeficiente A =");
	        //b = obtenerCoeficiente("Coeficiente B =");
	        //c = obtenerCoeficiente("Coeficiente C =");
	        
	        // 2. Checar el valor del coeficiente y calcular raices
	        if(a == 0)
	        {
	            if(b==0)
	            {
	                //JOptionPane.showMessageDialog(null,"No hay Ecuacion, por lo tanto no hay raices...");
	                resultado="No hay Ecuacion, por lo tanto no hay raices...";
	            }
	            else
	            {
	                x = -(float)c/b;
	                //JOptionPane.showMessageDialog(null,"Ecuacion Lineal X = "+x);
	                resultado="Ecuacion Lineal X = "+x;
	            }
	        }
	        else
	        {
	            radical = b*b - 4*a*c;
	            
	            if(radical < 0)
	            {
	                //JOptionPane.showMessageDialog(null,"Raices Imginarias...");
	                resultado="Raices Imginarias...";
	            }
	            else
	            {
	                x1 = (-b - (float)Math.sqrt(radical)) / (2*a);
	                x2 = (-b + (float)Math.sqrt(radical)) / (2*a);
	                
	                //JOptionPane.showMessageDialog(null,"Raices Reales\nX1 = "+x1+"\nX2 = "+x2);
	                resultado="Raices Reales\nX1 = "+x1+"\nX2 = "+x2;
	            }
	        }
	        return resultado;
	    }
		
		public static String tabla(int n)
	    {
	        String resultado="";
	        
	        resultado = "Tabla de Multiplicar del "+n+":\n";
	        for(int i=1; i<=10; i++)
	            resultado = resultado + n + " x "+ i + " = " + (n*i) + "\n";
	        
	        return resultado;
	    }
		
		/*private  void calcularTabla()
		{
			// 1. obtener el no. del factorial a calcular
			int n = pedirValor("No. de la Tabla N =");
			
			// 2. Calcular Factorial de N
	        String resultado = tabla(n);
	        
	        // 3. Desplegar resultado de la Tabla
	        JOptionPane.showMessageDialog(null,resultado);
		}*/
		
}	
	
		


