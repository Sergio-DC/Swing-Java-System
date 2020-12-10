import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class FactorialGUI extends JFrame implements ActionListener {
	private JButton bCalcular, bSalir;
	private JTextField tfInput;
	private JTextArea taOutput;
	private JPanel panel1, panel2;
	
	
	
	
	public FactorialGUI(){
		//Crear objetos
		bCalcular=new JButton("Calcular Factorial");
		bSalir=new JButton("Salir");
		tfInput=new JTextField();
		taOutput=new JTextArea(15,15);
		panel1=new JPanel();
		panel2=new JPanel();
		//Agregar el ActionListener al boton
		bCalcular.addActionListener(this);
		bSalir.addActionListener(this);
		//Determinar el Layout
		panel1.setLayout(new GridLayout(2, 2));
		panel2.setLayout(new FlowLayout());
		//Agregar los elementos a los paneles
		panel1.add(new JLabel("Ingresa un numero"));
		panel1.add(tfInput);
		panel1.add(bCalcular);
		panel1.add(bSalir);
		panel2.add(panel1);
		panel2.add(taOutput);
		//Colocar el panel correspondiente en el Frame y hacerlo visible
		add(panel2);
		setSize(300,300);
		setVisible(false);
		setResizable(false);
	}
	
	
		
			 /*private static String factorial(int num){
			        int fac=1;
			        
			        for(int i=1; i<=num; i++)
			            fac = fac * i;
			        
			        return "El factorial de "+num+" es: "+fac;
			    }*/
	
	public JPanel getPanel2(){
		
		return this.panel2;
	}
			
		
		public void actionPerformed(ActionEvent event){
			if(event.getSource()==bCalcular)
			{
				try{
				
				String factorial=tfInput.getText();
				int fact=Integer.parseInt(factorial);
					
				if(fact<0){
						taOutput.setText("Error...");
					}else{
						String resultado=CalculosDP.factorial(fact);
						taOutput.setText(resultado);
					}
				
				}catch(Exception e)
				{
				taOutput.setText("Ingresa un numero");
								
				}		
			}
			
			if(event.getSource()==bSalir){
				panel2.setVisible(false);
			}
			
		}

		
	
	
	
	
	
	
	
		public static void main(String[] args){
		
		new FactorialGUI(); 
	}
	
	 

}
