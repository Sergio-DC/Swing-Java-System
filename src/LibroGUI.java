
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

public class LibroGUI extends JFrame implements ActionListener{
	private JButton bcapturar, bconsultar, bconsultarE, bconsultarT, bsalir;//Consultas por editorial, titulo, general y captura.
	private JTextField tfConsultarE, tfConsultarT, tfAutor;
	private JTextArea tadatos;
	private JPanel panel1, panel2;
	private LibroAD libro=new LibroAD();
	
	public LibroGUI(){
		super("Libros");
		
		//Inicializar objetos
		bcapturar=new JButton("Capturar");
		bconsultar=new JButton("Consultar");
		bconsultarE=new JButton("Consultar Editorial");
		bconsultarT=new JButton("Consultar Titulo");
		bsalir=new JButton("Salir");
		
		tfAutor=new JTextField();
		tfConsultarE=new JTextField();
		tfConsultarT=new JTextField();
		
		panel1=new JPanel();
		panel2=new JPanel();
		
		tadatos=new JTextArea(15, 30);
		
		//Agregar el actionListener
		bcapturar.addActionListener(this);
		bconsultar.addActionListener(this);
		bconsultarE.addActionListener(this);
		bconsultarT.addActionListener(this);
		bsalir.addActionListener(this);
		
		//Configurar Layout
		panel1.setLayout(new GridLayout(6, 2));
		panel2.setLayout(new FlowLayout());

		//Añadir al panel
		panel1.add(new JLabel("Autor"));
		panel1.add(tfAutor);
		panel1.add(new JLabel("Titulo"));
		panel1.add(tfConsultarT);
		panel1.add(new JLabel("Editorial"));
		panel1.add(tfConsultarE);
		panel1.add(bcapturar);
		panel1.add(bconsultar);
		panel1.add(bconsultarE);
		panel1.add(bconsultarT);
		panel1.add(bsalir);
		panel2.add(panel1);
		panel2.add(new JScrollPane(tadatos));
		
		//add(panel2);
		//setSize(500, 500);
		//setVisible(true);
		//setResizable(false);
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	public JPanel getPanel2(){
		return this.panel2;
	}
	
	public String obtenerDatos(){
		String autor, editorial, titulo, datos;
		
		
		autor=tfAutor.getText();
		editorial=tfConsultarE.getText();
		titulo=tfConsultarT.getText();
		if(autor.isEmpty()||editorial.isEmpty()||titulo.isEmpty()){
			datos="vacio";
		}else{
			datos=autor+"_"+titulo+"_"+editorial;
		}
		
		
		return datos;
	}
	
	public void actionPerformed(ActionEvent event){
		String resultado;
		if(event.getSource()==bcapturar){
			resultado=obtenerDatos();
			
			if(resultado.equals("vacio")){
				tadatos.setText("Un campo esta vacio");
			}else{
				resultado=libro.capturar(resultado);
				tadatos.setText(resultado);
			}
		}
		
		if(event.getSource()==bconsultar){
			
			resultado=libro.consultar();
			tadatos.setText(resultado);
			
		}
		
		if(event.getSource()==bconsultarE){
			
			resultado=libro.consultarE(tfConsultarE.getText());
			tadatos.setText(resultado);
		}
		
		if(event.getSource()==bconsultarT){
			resultado=libro.consultarT(tfConsultarT.getText());
			tadatos.setText(resultado);
			
		}
		
		if(event.getSource()==bsalir){
			panel2.setVisible(false);
		}
		
	}
	
	

}
