import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Audio extends JFrame implements ActionListener{
	
	private JTextField tfSong;
	private JButton bplay, bstop;
	private JPanel panel1, panel2, panel3;
	
	private AudioOS audioOS=new AudioOS();
	
	public Audio(){
		super("Audio OOP");
		
		//1. Crear los objetos de los atributos
		tfSong = new JTextField();
		bplay = new JButton("Play");
		bstop = new JButton("Stop");
		panel1 = new JPanel();
		panel2 = new JPanel();
		panel3 = new JPanel();
		
		//Adicionar ActionListener a los botones
		bplay.addActionListener(this);
		bstop.addActionListener(this);
		
		//2. Definir los Layouts para los JPanels
		panel1.setLayout(new GridLayout(1, 4));
		panel2.setLayout(new GridLayout(1, 2));
		panel3.setLayout(new FlowLayout());
		
		//3. Adicionar los objetos a los panels correspondientes
		
		panel1.add(new JLabel("Canción a reproducir"));
		panel1.add(tfSong);
		panel1.add(bplay);
		panel1.add(bstop);
		
		panel2.add(new JLabel("Now playing: "));
		panel2.add(new JLabel("NO SONG"));
		
		panel3.add(panel1);
		panel3.add(panel2);
		
		//4. Adicionar panel3 al JFrame y hacerlo visible
		//add(panel3);
		//setSize(600, 300);
		//setVisible(true);
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void actionPerformed(ActionEvent e)
	{
		String song, transaccion;
		
		if(e.getSource()==bplay)
		{
			song=tfSong.getText();
			transaccion=audioOS.reproducir(song);
			
			panel2.setVisible(false);
			
			panel2.removeAll();
			
			panel2.add(new JLabel(transaccion));
			
			panel2.setVisible(true);
		}
		
		if(e.getSource()==bstop)
		{
			audioOS.stop();
		}
		
	}

	public JPanel getPanel3()
	{
		return this.panel3;
	}
}

