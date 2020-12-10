import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class Gestion_datosGUI extends JFrame implements ActionListener {
	private JPanel panel1, panel2;
	private JTextField tfartista, tfalbum, tfcancion;
	private JButton bregistrar, bconsultarArtista, bconsultarAlbum, bconsultarCancion;
	private JTextArea tadatos;
	private Gestion_datosAD datosAD = new Gestion_datosAD();
	
	public Gestion_datosGUI()
	{
		super("Gestión de datos");
		
		//Crear los objetos 
		panel1 = new JPanel();
		panel2 = new JPanel();
		tfartista = new JTextField();
		tfalbum = new JTextField();
		tfcancion= new JTextField();
		bregistrar = new JButton("Registrar");
		bconsultarArtista = new JButton("Consultar Artistas");
		bconsultarAlbum = new JButton("Consultar Albums");
		bconsultarCancion = new JButton("Consultar Canciónes");
		
		tadatos = new JTextArea(10, 30);
		
		//Aplicar layouts
		panel1.setLayout(new GridLayout(5, 2));
		panel2.setLayout(new FlowLayout());
		
		//Adicionar los  ActionListener a los botones correspondientes
		bconsultarArtista.addActionListener(this);
		bconsultarAlbum.addActionListener(this);
		bconsultarCancion.addActionListener(this);
		bregistrar.addActionListener(this);
		
		//Adicionar los elementos a los paneles
		panel1.add(new JLabel("Artista"));
		panel1.add(tfartista);
		panel1.add(new JLabel("Album"));
		panel1.add(tfalbum);
		panel1.add(new JLabel("Canción"));
		panel1.add(tfcancion);
		panel1.add(bregistrar);
		panel1.add(bconsultarArtista);
		panel1.add(bconsultarAlbum);
		panel1.add(bconsultarCancion);
		panel2.add(panel1);
		panel2.add(new JScrollPane(tadatos));
		
		//Modificar caraceristas del  Frame
		//add(panel2);
		//setSize(500, 500);
		//setVisible(true);
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
		
	}
	
	public JPanel getPanel2()
	{
		return this.panel2;
	}
	
	private void registrarDatos(String artista, String album, String cancion)
	{
		String datos;
		String artistaGUI, albumGUI, cancionGUI;
		
		if(artista.isEmpty()||album.isEmpty()||cancion.isEmpty())
		{
			datos = "Un campo esta vacio...";
			 tadatos.setText(datos);
		}
		else
		{
			artistaGUI =  datosAD.registrarArtistas(artista);
			tadatos.setText("");
			tadatos.append(artistaGUI);
			albumGUI = datosAD.registrarAlbum(artista, album);
			tadatos.append(albumGUI);
			cancionGUI = datosAD.registrarCancion(album, cancion);
			tadatos.append(cancionGUI);
		}
		
	}
	
	public void actionPerformed(ActionEvent e)
	{
		String artista, album, cancion; 
		String consultaArtista, consultaAlbum, consultaCancion;
		
		if(e.getSource()==bregistrar)
		{
			artista = tfartista.getText();
			album = tfalbum.getText();
			cancion = tfcancion.getText();
			
			registrarDatos(artista, album, cancion);		
			
		}
		
		if(e.getSource()==bconsultarArtista)
		{
			consultaArtista = datosAD.consultaArtista();
			tadatos.setText("");
			tadatos.setText(consultaArtista);
		}
		
		if(e.getSource()==bconsultarAlbum)
		{
			consultaAlbum = datosAD.consultaAlbum();
			tadatos.setText("");
			tadatos.setText(consultaAlbum);
		}
		
		if(e.getSource()==bconsultarCancion)
		{
			consultaCancion = datosAD.consultaCancion();
			tadatos.setText("");
			tadatos.setText(consultaCancion);
		}
	}
	
	
	public static void main(String[] args)
	{
		new Gestion_datosGUI();
	}
		

}
