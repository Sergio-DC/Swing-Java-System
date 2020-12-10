

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.*;

public class GradosGUI extends JFrame implements ActionListener {
	 
	
	private JLabel label_1;
	private JTextField tfGrados;
	private JButton bCtoF, bFtoC, bSalir;
	private JTextArea taDatos;
	private	JPanel panel_1, panel_2;
	
	public GradosGUI(){
		//Definir variables tipo objeto
		label_1=new JLabel("Introduce los grados");
		tfGrados=new JTextField();
		bCtoF=new JButton("C° -> F°");
	    bFtoC=new JButton("F° -> C°");
	    bSalir=new JButton("Salir");
		
	    taDatos=new JTextArea(8,15);
		panel_1=new JPanel();
		panel_2=new JPanel();
		//Definir los Layouts
		panel_1.setLayout(new GridLayout(2,2));
		panel_2.setLayout(new FlowLayout());
		//Agregar acciones a los botones
		bCtoF.addActionListener(this);
		bFtoC.addActionListener(this);
		bSalir.addActionListener(this);
		//Agregar elementos a los Paneles
		panel_1.add(bCtoF);
		panel_1.add(tfGrados);		
		panel_1.add(bFtoC);
		panel_1.add(bSalir);
		
		panel_2.add(panel_1);
		panel_2.add(new JScrollPane(taDatos));
		//Agregar los paneles a los Frames
		add(panel_2);
		//Ajustar medidas del Frame		
		
			//setBounds(250, 250, 300, 300);
			//setResizable(false);
			//setVisible(true);
		//Comandos para cerrar la aplicación
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	public JPanel getPanel2(){
		
		return this.panel_2;
	}
	
	public void actionPerformed(ActionEvent event){
		
		if(event.getSource()==bCtoF){
		
			try{
			
				    String strGrados=tfGrados.getText();
					
				    float grados=Float.parseFloat(strGrados);				   
				    float resultado=CalculosDP.gc_gf(grados);
				    taDatos.setText(""+resultado);
					
			}
			catch(Exception e)
			{
				//System.out.println("error: "+e);
				taDatos.setText("Error: Debes ingresar numeros enteros...");
			}
		}
		
		if(event.getSource()==bFtoC){
			
			try{
				String strGrados=tfGrados.getText();
				float grados=Float.parseFloat(strGrados);
				float resultado=CalculosDP.gf_gc(grados);
				taDatos.setText(""+resultado);
			}catch(Exception e){
				
				taDatos.setText("Error: Debes ingresar numeros enteros...");
			}
			
		}
		
		if(event.getSource()==bSalir){
			panel_2.setVisible(false);
			
		}
		
	}
	
	
	
	public static void main(String[]args){
		GradosGUI ventana=new GradosGUI();
		
	}
	

}
