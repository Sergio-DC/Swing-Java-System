import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.StringTokenizer;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class AutoGUI extends JFrame implements ActionListener {

	
		 private JTextField  tfClave, tfMarca, tfTipo, tfExistencia, tfPrecio, tfModelo;
		  private JButton     bCapturar, bConsultar, bSalir, bMarca, bConsultarTipo, bConsultarClave;
		  private JTextArea   taDatos;
		  private JPanel      panel1, panel2;
		  
		  private AutoAD auto=new AutoAD();

		  public AutoGUI()
		  {
		    super("Catálogo de automóviles");

		    // 1. Crear los objetos de los atributos o variables de clase-instancia
		    tfClave             = new JTextField();
		    tfMarca            = new JTextField();
		    tfTipo              = new JTextField();
		    tfModelo            = new JTextField();
		    tfExistencia		=new JTextField();
		    tfPrecio			=new JTextField();
		    bCapturar           = new JButton("Capturar datos ");
		    bConsultar          = new JButton("Consultar datos ");
		    bConsultarClave    = new JButton("Consultar Clave");
		    bConsultarTipo      = new JButton("Consultar Tipo");
		    bMarca				=new JButton("Consultar Marca");
		    bSalir              = new JButton("EXIT");
		    taDatos             = new JTextArea(15,30);
		    panel1              = new JPanel();
		    panel2              = new JPanel();

		    // 1.1 Adicionar el  addActionListener a los JFrame
		    bSalir.addActionListener(this);
		    bCapturar.addActionListener(this);
		    bConsultar.addActionListener(this);
		    bConsultarTipo.addActionListener(this);
		    bConsultarClave.addActionListener(this);
		    bMarca.addActionListener(this);

		    // 2. Adicionar los objetos de los atributos a los JPanels correspondientes
		    panel1.setLayout(new GridLayout(9,2));
		    panel2.setLayout(new FlowLayout());

		    panel1.add(new JLabel("Clave: "));
		    panel1.add(tfClave);

		    panel1.add(new JLabel("Marca: "));
		    panel1.add(tfMarca);

		    panel1.add(new JLabel("Tipo: "));
		    panel1.add(tfTipo);

		    panel1.add(new JLabel("Modelo: "));
		    panel1.add(tfModelo);
		    
		    panel1.add(new JLabel("Existencia"));
		    panel1.add(tfExistencia);
		    
		    panel1.add(new JLabel("Precio"));
		    panel1.add(tfPrecio);

		    panel1.add(bCapturar);
		    panel1.add(bConsultar);
		    panel1.add(bMarca);
		    panel1.add(bConsultarTipo);
		    panel1.add(bConsultarClave);
		    panel1.add(bSalir);

		    panel2.add(panel1);
		    panel2.add(new JScrollPane(taDatos));

		    // 3. Adicionar los paneles al JFrame y hacerlo visible
		    //add(panel2);
		    //setSize(500,500);
		    //setVisible(true);

		    //setSize(500,500);
		    //setVisible(true);

		    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		  
	}
		  
		  private void desplegarTF(String datos){
			  StringTokenizer st;
			  String str;
			  
			  st=new StringTokenizer(datos, "_");
			   tfClave.setText(st.nextToken());
			   tfMarca.setText(st.nextToken());
			   tfTipo.setText(st.nextToken());
			   tfModelo.setText(st.nextToken());
			   tfExistencia.setText(st.nextToken());
			   tfPrecio.setText(st.nextToken());
		  }
		  
		  private String obtenerDatos()
		  {
		    String datos;

		    String clave    = tfClave.getText();
		    String marca   = tfMarca.getText();
		    String tipo     = tfTipo.getText();
		    String modelo	=tfModelo.getText();
		    String existencia	=tfExistencia.getText();	
		    String precio    = tfPrecio.getText();

		    if(clave.equals("") || marca.isEmpty() || tipo.equals("") || modelo.isEmpty()||existencia.isEmpty()||precio.isEmpty())
		    {
		        datos = "VACIO";
		    }
		    else
		    {
		      try
		      {
		    	int nexistencia = Integer.parseInt(existencia); 
		        int nprecio = Integer.parseInt(precio);
		        boolean existeCopia=auto.compararClave(clave);
		        
		        if(existeCopia==true){
		        	datos= "La clave ya existe";
		        	return datos;
		        }
		        
		        datos = clave+"_"+marca+"_"+tipo+"_"+modelo+"_"+existencia+"_"+precio;
		      }
		      catch(Exception e)
		      {
		        datos = "NO_NUMERICO";
		        System.out.println("error: "+ e);
		      }
		    }
		    return datos;
		  }
		  
		  public void actionPerformed(ActionEvent e){
			  String datos, resultado="";
			  
			  if(e.getSource()==bCapturar){
				// 1. Obtener datos de los JTextField
		          datos = obtenerDatos();
		          // 2. Capturar datos a traves del metodo correspondiente del onjeto BancoAd
		          
		          switch(datos){
		          case "VACIO":
		        	  resultado = "Algun campo esta vacio...";
		        	  break;
		          case "NO_NUMERICO":
		        	  resultado="El saldo no es numerico ó\nLa existencia no es numerico";
		        	  break;
		          case "La clave ya existe":
		        	  resultado="La clave ya existe...";
		        	  break;
		          default:
		        	resultado=auto.capturar(datos);
		        	break;
		          }
		       
		          // 3. Desplegar el resultado de la transaccion
		          taDatos.setText(resultado);
			  }
			  
			  if(e.getSource()==bConsultar){
				  // 1. Obtener datos de cliente a traves del metodo de consultar datos de BancoAD
		          datos = auto.consultarDatos();
		          // 2. Desplegar los datos
		          taDatos.setText(datos);
				  
			  }
			  
			  if(e.getSource() == bMarca)
		      {
		        // 1. Obtener el tipo de cuenta a buscar del tfTipo
		        String marca = tfMarca.getText();
		        // 2. Utilizar el metodo consultarTipo() de BancoAD para obtener los clientes con ese tipo de Cuenta
		        datos = auto.consultarMarca(marca);
		        // 3. Desplegar resultado
		        taDatos.setText(datos);
		      }
			  if(e.getSource()==bConsultarTipo){
				  String tipo=tfTipo.getText();
				  datos=auto.consultarTipo(tipo);
				  taDatos.setText(datos);
			  }
			  
			  if(e.getSource()==bConsultarClave){
				  String clave=tfClave.getText();
				  datos=auto.consultarClave(clave);
				    //Desplegar datos en textfield
			        desplegarTF(datos);
				     //  Desplegar resultado
			        taDatos.setText(datos);
			  }
			  
			  if(e.getSource()==bSalir){
				  panel2.setVisible(false);
			  }			  
			  
		  }
		  
		 public JPanel getPanel2(){
			 return this.panel2;
		 }
}
