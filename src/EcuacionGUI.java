import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
	import javax.swing.JTextArea;
	import javax.swing.JScrollPane;
	import javax.swing.JLabel;
	import javax.swing.JPanel;
	import javax.swing.JFrame;
	import java.awt.GridLayout;
	import java.awt.FlowLayout;
	import java.awt.event.ActionListener;
	import java.awt.event.ActionEvent;


	public class EcuacionGUI /*extends JFrame*/ implements ActionListener
	{
		private JTextField tfCoeficienteA, tfCoeficienteB, tfCoeficienteC;
		private JButton bCalcular, bSalir;
		private JTextArea taDatos;
		private JPanel panel1, panel2;
		//CalculosDP calculosDP=new CalculosDP();//SIRVE PARA SUSTUIR A LA HERENCIA DEL JFRAME
		private ImageIcon icono_1, icono_2;
		CalculosDP calculos=new CalculosDP();		
		JFrame frame=new JFrame();
		
		
		
		public EcuacionGUI()
		{
			//super("Ecuacion Cuadratica");
			
			// 1. Crear objetos
			icono_1=new ImageIcon("imagenes/calcular.jpg");
			icono_2=new ImageIcon("imagenes/salir.jpg");
			
			tfCoeficienteA = new JTextField();
			tfCoeficienteB = new JTextField();
			tfCoeficienteC = new JTextField();
			bCalcular      = new JButton("Calcular", icono_1);
			bSalir         = new JButton("Exit", icono_2);
			taDatos        = new JTextArea(8,20);
			panel1         = new JPanel();
			panel2         = new JPanel();
			
			
			// addActionListener a los JButtons
			bCalcular.addActionListener(this);
			bSalir.addActionListener(this);
			
			// 2. Establecer Layout de los panels
			panel1.setLayout(new GridLayout(4,2));
			panel2.setLayout(new FlowLayout());
			
			// 3. Adicionar los objetos a los panels correspondientes
			panel1.add(new JLabel("Coeficiente A = "));
			panel1.add(tfCoeficienteA);
			panel1.add(new JLabel("Coeficiente B = "));
			panel1.add(tfCoeficienteB);
			panel1.add(new JLabel("Coeficiente C = "));
			panel1.add(tfCoeficienteC);
			panel1.add(bCalcular);
			panel1.add(bSalir);
			
			
			panel2.add(panel1);
			//panel2.add(taDatos);
			panel2.add(new JScrollPane(taDatos));
			
			//frame.add(panel2);
			//frame.setBounds(225, 225, 300, 350);
			//frame.setVisible(true);
			//frame.setDefaultCloseOperation(0);
			
			
			
		
			
		}
		
		public JPanel getPanel2(){
			
			return this.panel2;
		}
		
		
		public void actionPerformed(ActionEvent e)
		{
			String resultado;
			String strA, strB, strC;
			int a, b, c;
			
			if(e.getSource() == bCalcular)
			{
				try
				{
					// 1. Obtener coficientes de los JTextFields
					strA = tfCoeficienteA.getText();
					strB = tfCoeficienteB.getText();
					strC = tfCoeficienteC.getText();
					
					a = Integer.parseInt(strA);
					b = Integer.parseInt(strB);
					c = Integer.parseInt(strC);
					
					// 2. Calcular raices a traves del metodo ecuacion de CalculosDP
					resultado=calculos.ecuacion(a, b, c);
					// 3. Desplegar el resultado
					taDatos.setText(resultado);
				}
				catch(NumberFormatException nfe)
				{
					System.out.println("Error: "+nfe);
					taDatos.setText("Error: los coeficiente deben ser numeros enteros...");
				}
			}
			
			if(e.getSource() == bSalir)
			{
				//System.exit(0);
				panel2.setVisible(false);
			}
		}
		
		
	}
	

