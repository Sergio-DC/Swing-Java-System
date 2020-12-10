
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JOptionPane;

import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ExponencialGUI extends JFrame implements ActionListener
{
    // Atributos, caracteristicas o propiedades de la clase
    private JTextField tfBase, tfExponente;
    private JButton bCalcular, bSalir;
    private JPanel panel1, panel2;
    private JTextArea taDatos;
    
    //private CalculosDP calculo = new CalculosDP();
    
    public ExponencialGUI()
    {
        // 1. Crear los objetos de los atributos
        tfBase      = new JTextField();
        tfExponente = new JTextField();
        bCalcular   = new JButton("Y = B ^ X");
        bSalir      = new JButton("Exit");
        panel1      = new JPanel();
        panel2      = new JPanel();
        taDatos     = new JTextArea(10,20);
        
        // Adicionar addActionListener a los botones
        bCalcular.addActionListener(this);
        bSalir.addActionListener(this);
        
        // 2. Definir un Layout para el panel1 y panel2
        panel1.setLayout(new GridLayout(3,2));
        panel2.setLayout(new FlowLayout());
        
        // 3. Adicionar los objetos de los atributos a los panels correspondientes
        panel1.add(new JLabel("Base = "));
        panel1.add(tfBase);
        panel1.add(new JLabel("X = "));
        panel1.add(tfExponente);
        panel1.add(bCalcular);
        panel1.add(bSalir);
        
        panel2.add(panel1);
        panel2.add(new JScrollPane(taDatos));
        
        // 4. Adicionar los panels al JFrame y hacer visible el JFrame
        //add(panel2);
        //setSize(400,400);
        //setVisible(true);
    }
    
       public JPanel getPanel2(){
    	
    	return this.panel2;
    }
    
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == bCalcular)
        {
        	String resultado;
        	int y;
        	
            try
            {
                // Pedir Base y X
                String str = tfBase.getText();
                int base = Integer.parseInt(str);
            
                str = tfExponente.getText();
                int x = Integer.parseInt(str);
            
                // Calcular exponencial
                //int expo = exponencial(base,x);
                if(x < 0)          
	            {
	            	y = CalculosDP.exponencial(base,-x);
	            	resultado = "Exponencial Y = "+base+" ^ "+x+" = 1/"+y;
	            	
	            }
	            else
	            {
	            	y = CalculosDP.exponencial(base,x);
	 	          	resultado = "Exponencial Y = "+base+" ^ "+x+" = "+y;
	            }
                
                // Desplegar resultado
                taDatos.setText(resultado);
            }
            catch(NumberFormatException nfe)
            {
                taDatos.append("Error: teclea un valor numerico...\n");
            }
        }
        
        if(e.getSource() == bSalir)
        {
            panel2.setVisible(false);
        }
    }
    
    public static void main(String args[])
    {
        new ExponencialGUI();
    }
}



