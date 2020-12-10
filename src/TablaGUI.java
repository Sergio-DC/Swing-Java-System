
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TablaGUI extends JFrame implements ActionListener
{
	private JTextField tfNumero = new JTextField();	
	private JButton bCalcular, bSalir;
	private JTextArea taDatos = new JTextArea(12,15);
	
	private JPanel panel1, panel2;
	
	//private CalculosDP calculo = new CalculosDP();
	
	public TablaGUI()
	{
		super("Tabla de Multiplicar");
		
		panel1 = new JPanel();
		panel2 = new JPanel();
		
		panel1.setLayout(new GridLayout(2,2));
		
		panel1.add(new JLabel("Numero de la Tabla = "));
		panel1.add(tfNumero);
		
		bCalcular = new JButton("Tabla de N");
		panel1.add(bCalcular);
		bCalcular.addActionListener(this);
		
		bSalir = new JButton("Salir");
		panel1.add(bSalir);
		bSalir.addActionListener(this);
		
		panel2.setLayout(new FlowLayout());
		
		panel2.add(panel1);
		panel2.add(new JScrollPane(taDatos));
		
		//add(panel2);
		//setSize(300,300);
		//setVisible(true);
	}
	
	/*private String tabla(int n)
    {
        String resultado="";
        
        for(int i=1; i<=10; i++){
            resultado = resultado + n + " x "+ i + " = " + (n*i) + "\n";
            
        }
        System.out.println(resultado);
        return resultado;
    }*/
	
	
	public  JPanel getPanel2(){
		
		return this.panel2;
	}
	
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource() == bCalcular)
		{
			try
			{
				// 1. obtener el no. del factorial a calcular
				String strN = tfNumero.getText();
				int n = Integer.parseInt(strN);
				
				// 2. Calcular Factorial de N
                String resultado = CalculosDP.tabla(n);
                
                // 3. Desplegar resultado de la Tabla
                String respuesta = "Tabla del "+n+":\n";
                respuesta = respuesta + resultado;
                taDatos.setText(respuesta);
							
			}
            catch(NumberFormatException nfe)
            {
                taDatos.setText("N debe ser numerico entero...");
            }
		}
		
        if(e.getSource() == bSalir)
        {
            panel2.setVisible(false);
        }
	}
	
	/*public static void main(String args[])
	{
		new TablaGUI();
	}*/

}
