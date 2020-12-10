
import javax.swing.JFrame;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProyectoGUI extends JFrame implements ActionListener
{
	private JMenuBar mbProyecto, mbPrueba; //mbPrueba borrarlo al finaliar!!!
	private JMenu menuCalculos, menuGrados, menuArchivos, menuAudio, menuItunes;
	private JMenuItem miEcuacion, miExponencial, miFactorial, miTabla,miGC_GF, miGF_GC, miLibros, miBanco, miAuto
	, miAudio, miItunes, miGDatos, miSalir, miExit;
	private JPanel panel1; //panelPrueba; //Borrar panelPrueba al finalizar!!!
	
	private EcuacionGUI ecuacion=new EcuacionGUI();
	private FactorialGUI factorial=new FactorialGUI();
	private TablaGUI tabla=new TablaGUI();
	private GradosGUI grados=new GradosGUI();
	private ExponencialGUI exponente= new ExponencialGUI();
	private ClienteGUI banco=new ClienteGUI();
	private LibroGUI libro=new LibroGUI();
	private AutoGUI auto=new AutoGUI();
	private ITunesGUI itunes = new ITunesGUI();
	private Gestion_datosGUI Gdatos= new Gestion_datosGUI(); 
	private Audio audio = new Audio();
		
	
	
	public ProyectoGUI()
	{
		super("Proyecto 2° Parcial");
		
		//1. Crear objetos de los atributos
		mbProyecto = new JMenuBar();
	
		// Se crean los menus que estaran dentro del JMenuBar
		menuCalculos= new JMenu("Calculos Varios");
		menuGrados=new JMenu("Conversion Grados");
		menuArchivos=new JMenu("Archivos");
		menuAudio = new JMenu("Audio");
		menuItunes = new JMenu("ITunes");
		
		//Se crean los elementos que estaran dentro de los menús
		miEcuacion=new JMenuItem("Ecuacion Cuadratica");
		miExponencial=new JMenuItem("Exponencial Y=B^X");
		miFactorial=new JMenuItem("Factorial de N");
		miTabla=new JMenuItem("Tabla de N");
		miGC_GF=new JMenuItem("G. Centigrados a G. Fahrenheit");
		miGF_GC= new JMenuItem("G. Fahrenheit a G. Centigrados");
		miLibros= new JMenuItem("Libros");
		miBanco= new JMenuItem("Banco");
		miAuto= new JMenuItem("Autos");
		miExit= new JMenuItem("Exit");
		miAudio = new JMenuItem("Audio");
		miGDatos = new JMenuItem("Gestión\nArchivos");
		miItunes = new JMenuItem("ITunes");
		miSalir=new JMenuItem("Salir");			
		
				
		//1.1   Adicionar addActionListener a los botones
		miEcuacion.addActionListener(this);
		miFactorial.addActionListener(this);
		miExponencial.addActionListener(this);
		miGC_GF.addActionListener(this);
		miGF_GC.addActionListener(this);
		miTabla.addActionListener(this);
		miBanco.addActionListener(this);
		miLibros.addActionListener(this);
		miAuto.addActionListener(this);
		miExit.addActionListener(this);
		miAudio.addActionListener(this);
		miGDatos.addActionListener(this);
		miItunes.addActionListener(this);		
		miSalir.addActionListener(this);
				
		
		//2. Adicionar lo JMenuItems en los JMenu correspondientes
		menuGrados.add(miGC_GF);
		menuGrados.add(miGF_GC);
		menuCalculos.add(miEcuacion);
		menuCalculos.add(miFactorial);
		menuCalculos.add(menuGrados);
		menuCalculos.add(miExponencial);
		menuCalculos.add(miTabla);
		menuCalculos.add(miSalir);
		
		menuArchivos.add(miBanco);
		menuArchivos.add(miLibros);
		menuArchivos.add(miAuto);
		
		menuAudio.add(miAudio);
		menuAudio.add(menuItunes);
		
		menuItunes.add(miGDatos); 
		menuItunes.add(miItunes);
		
		//3. Adicionar menuCalculos a JMenuBar mbProyecto
		mbProyecto.add(menuCalculos);
		mbProyecto.add(menuArchivos);
		mbProyecto.add(menuAudio);
		mbProyecto.add(miExit);
		
		/*************************************************/
		/*mbPrueba = new JMenuBar();
		mbPrueba.add(menuItunes);*/
		
		//3.1 Crear los panel correspondientes
		

		//4. Adicionar mbProyecto al JFrame  y hacerlo visible
		setJMenuBar(mbProyecto);
		//setJMenuBar(mbPrueba);
		
		
		setSize(500,500);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		
	}
	
	private void OcultarPanel(){
		
		if(panel1!=null)
			panel1.setVisible(false);
	}
		
	public void actionPerformed(ActionEvent evento)
	{	
		if(evento.getSource()==miEcuacion)
		{
			
			OcultarPanel();
			panel1=ecuacion.getPanel2();
			panel1.setVisible(true);
			add(panel1);
			setVisible(true);
		}
		if(evento.getSource()==miFactorial){
			//FactorialGUI obj = new FactorialGUI();
			//panel1.add(obj.panel2);
			OcultarPanel();
			panel1=factorial.getPanel2();
			panel1.setVisible(true);
			add(panel1);
			setVisible(true);
		}
		
		if(evento.getSource()==miExponencial)
		{
			//ExponencialGUI obj=new ExponencialGUI();
			//panel1.add(obj.panel2);
			OcultarPanel();
			panel1=exponente.getPanel2();
			panel1.setVisible(true);
			add(panel1);
			setVisible(true);
		}
		if(evento.getSource()==miTabla)
		{
			//TablaGUI obj=new TablaGUI();
			//panel1.add(obj.panel2);
			OcultarPanel();
			panel1=tabla.getPanel2();
			panel1.setVisible(true);
			add(panel1);
			setVisible(true);
		}
		
		if(evento.getSource()==miGC_GF)
		{
			//GradosGUI obj=new GradosGUI();
			//panel1.add(obj.panel_2);
			OcultarPanel();
			panel1=grados.getPanel2();
			panel1.setVisible(true);
			add(panel1);
			setVisible(true);
		}
		
		if(evento.getSource()==miBanco)
		{
			OcultarPanel();
			panel1=banco.getPanel2();
			panel1.setVisible(true);
			add(panel1);
			setVisible(true);
		}
		
		if(evento.getSource()==miLibros)
		{
			OcultarPanel();
			panel1=libro.getPanel2();
			panel1.setVisible(true);
			add(panel1);
			setVisible(true);
		}
		
		if(evento.getSource()==miAuto)
		{
			OcultarPanel();
			panel1=auto.getPanel2();
			panel1.setVisible(true);
			add(panel1);
			setVisible(true);
		}
		
		if(evento.getSource()==miAudio)
		{
			OcultarPanel();
			panel1 = audio.getPanel3();
			panel1.setVisible(true);
			add(panel1);
			setVisible(true);
		}
		
		if(evento.getSource()==miItunes)
		{
			OcultarPanel();
			panel1 = itunes.getPanel2();
			panel1.setVisible(true);
			add(panel1);
			setVisible(true);
		}
		
		if(evento.getSource()==miGDatos)
		{
			OcultarPanel();
			panel1 = Gdatos.getPanel2();
			panel1.setVisible(true);
			add(panel1);
			setVisible(true);
		}
		
		if(evento.getSource()==miExit)
		{
			System.exit(0);
		}
			
	}
	
	
	public static void main(String[] args)
	{		
		ProyectoGUI objeto= new ProyectoGUI();
		
	}

}
