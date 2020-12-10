

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JScrollPane;

import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.util.StringTokenizer;
import java.awt.event.ActionEvent;

public class ClienteGUI extends JFrame implements ActionListener
{
  private JTextField  tfNocta, tfNombre, tfTipo, tfSaldo;
  private JButton     bCapturar, bConsultar, bSalir, bConsultarCuenta, bConsultarTipo;
  private JTextArea   taDatos;
  private JPanel      panel1, panel2;

  private BancoAD banco = new BancoAD();

  public ClienteGUI()
  {
    super("BANAMEX");

    // 1. Crear los objetos de los atributos o variables de clase-instancia
    tfNocta             = new JTextField();
    tfNombre            = new JTextField();
    tfTipo              = new JTextField();
    tfSaldo             = new JTextField();
    bCapturar           = new JButton("Crear Cliente ");
    bConsultar          = new JButton("Consultar Cliente ");
    bConsultarCuenta    = new JButton("Consultar No. Cuenta");
    bConsultarTipo      = new JButton("Consultar Tipo de Cuenta");
    bSalir              = new JButton("EXIT");
    taDatos             = new JTextArea(15,30);
    panel1              = new JPanel();
    panel2              = new JPanel();

    // 1.1 Adicionar el  addActionListener a los JFrame
    bSalir.addActionListener(this);
    bCapturar.addActionListener(this);
    bConsultar.addActionListener(this);
    bConsultarTipo.addActionListener(this);
    bConsultarCuenta.addActionListener(this);

    // 2. Adicionar los objetos de los atributos a los JPanels correspondientes
    panel1.setLayout(new GridLayout(7,2));
    panel2.setLayout(new FlowLayout());

    panel1.add(new JLabel("No. de Cuenta: "));
    panel1.add(tfNocta);

    panel1.add(new JLabel("Nombre: "));
    panel1.add(tfNombre);

    panel1.add(new JLabel("Tipo de Cuenta: "));
    panel1.add(tfTipo);

    panel1.add(new JLabel("Saldo: "));
    panel1.add(tfSaldo);

    panel1.add(bCapturar);
    panel1.add(bConsultar);
    panel1.add(bConsultarTipo);
    panel1.add(bConsultarCuenta);
    panel1.add(bSalir);

    panel2.add(panel1);
    panel2.add(new JScrollPane(taDatos));

    // 3. Adicionar los paneles al JFrame y hacerlo visible
   // add(panel2);
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
	   tfNocta.setText(st.nextToken());
	   tfNombre.setText(st.nextToken());
	   tfTipo.setText(st.nextToken());
	   tfSaldo.setText(st.nextToken());
  }
  
  public JPanel getPanel2(){
	  return this.panel2;
  }

  private String obtenerDatos()
  {
    String datos;

    String nocta    = tfNocta.getText();
    String nombre   = tfNombre.getText();
    String tipo     = tfTipo.getText();
    String saldo    = tfSaldo.getText();

    if(nocta.equals("") || nombre.isEmpty() || tipo.equals("") || saldo.isEmpty())
    {
        datos = "VACIO";
    }
    else
    {
      try
      {
    	int cta = Integer.parseInt(nocta);  
        int nsaldo = Integer.parseInt(saldo);
        boolean existeCopia=banco.compararCuenta(nocta);
        
        if(existeCopia==true){
        	datos= "El No. de cuenta ya existe...";
        	return datos;
        }
        
        datos = nocta+"_"+nombre+"_"+tipo+"_"+saldo;
      }
      catch(Exception e)
      {
        datos = "NO_NUMERICO";
        System.out.println("error: "+ e);
      }
    }
    return datos;
  }

    public void actionPerformed(ActionEvent e)
    {
        String datos,resultado = "";

      if(e.getSource() == bCapturar)
      {
          // 1. Obtener datos de los JTextField
          datos = obtenerDatos();
          // 2. Capturar datos a traves del metodo correspondiente del objeto BancoAd
          
          switch(datos){
          case "VACIO":
        	  resultado = "Algun campo esta vacio...";
        	  break;
          case "NO_NUMERICO":
        	  resultado="El saldo no es numérico\n ó el No. de cuenta no es numérico";
        	  break;
          case "El No. de cuenta ya existe...":
        	  resultado="El No. de cuenta ya existe";
        	  break;
          default:
        	resultado=banco.capturar(datos);
        	break;
          }
       
          // 3. Desplegar el resultado de la transaccion
          taDatos.setText(resultado);
      }
      if(e.getSource() == bConsultar)
      {
          // 1. Obtener datos de cliente a traves del metodo de consultar datos de BancoAD
          datos = banco.consultarDatos();
          // 2. Desplegar los datos
          taDatos.setText(datos);
      }
      if(e.getSource() == bConsultarTipo)
      {
        // 1. Obtener el tipo de cuenta a buscar del tfTipo
        String tipo = tfTipo.getText();
        // 2. Utilizar el metodo consultarTipo() de BancoAD para obtener los clientes con ese tipo de Cuenta
        datos = banco.consultarTipo(tipo);
        // 3. Desplegar resultado
        taDatos.setText(datos);
      }
      if(e.getSource() == bConsultarCuenta)
      {
        // 1. Obtener el tipo de cuenta a buscar del tfTipo
        String Numero = tfNocta.getText();
        // 2. Utilizar el metodo consultarTipo() de BancoAD para obtener los clientes con ese tipo de Cuenta
        datos = banco.consultarNoCta(Numero);
        //3.Desplegar datos en textfield
        ;
        if(datos=="No se localizo el Numero de Cuenta: ")
        {
        	taDatos.setText(datos);
        }
        else
        {
        	desplegarTF(datos);
        }        
        
        // 3. Desplegar resultado
        taDatos.setText(datos);
      }
      if(e.getSource() == bSalir)
      {
        panel2.setVisible(false);
      }
    }
    
    public static void main(String[] args){
    	new ClienteGUI();
    }


}
