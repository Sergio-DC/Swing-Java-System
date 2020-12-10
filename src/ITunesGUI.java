import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import java.awt.*;
import java.awt.event.ActionListener;
import java.util.Vector;
import java.awt.event.ActionEvent;

public class ITunesGUI extends JFrame implements ActionListener, ListSelectionListener
{
    private JTextField tfArtist;
    private JButton    bArtista, bCatalogo, bPlay, bStop;
    private JPanel     panelArtistas, panelAlbums, panelSongs, panelOpciones, panelPlayStop, panelPrincipal;
    
    private ITunesAD itunesAD= new ITunesAD();
    private Vector<String> vectorArtistas, vectorAlbums, vectorCanciones;
    private JList<String> listaArtistas, listaAlbums, listaSongs;
    
    private String artistaElegido, albumElegido, cancionElegida;
    
    private AudioOS audio= new AudioOS();
    
    public ITunesGUI()
    {
        super("ITunes OOP");
        
        // 1. Crear los objetos de los atributos
        tfArtist       = new JTextField();
        bArtista       = new JButton("Artista");
        bCatalogo      = new JButton("Catalogo");
        bPlay          = new JButton("Play");
        bStop          = new JButton("Stop");
        panelOpciones  = new JPanel();
        panelArtistas  = new JPanel();
        panelAlbums    = new JPanel();
        panelSongs     = new JPanel();
        panelPlayStop  = new JPanel();
        panelPrincipal = new JPanel();
        
        //Adicionar a los  JButtons addActionListner
        bArtista.addActionListener(this);
        bCatalogo.addActionListener(this);
        bPlay.addActionListener(this);
        bStop.addActionListener(this);
        
        // 2. Definir los Layouts para los JPanels
        panelOpciones.setLayout(new GridLayout(1,4));
        panelArtistas.setLayout(new GridLayout(1,1));
        panelAlbums.setLayout(new GridLayout(1,1));
        panelSongs.setLayout(new GridLayout(1,1));
        panelPlayStop.setLayout(new FlowLayout());
        panelPrincipal.setLayout(new BorderLayout(10,10));
        
        // 3. Adicionar los objetos a los JPanels correspondientes
        panelOpciones.add(new JLabel("Artista: "));
        panelOpciones.add(tfArtist);
        panelOpciones.add(bArtista);
        panelOpciones.add(bCatalogo);
        
        panelArtistas.add(new JLabel("Artistas-Grupos"));
        panelAlbums.add(new JLabel("                                    Albums-CDs"));
        panelSongs.add(new JLabel("Songs List"));
        
        panelPlayStop.add(new JLabel("Now Playing: No playing Song"));
        panelPlayStop.add(bPlay);
        panelPlayStop.add(bStop);
        
        panelPrincipal.add(panelOpciones, BorderLayout.NORTH);
        panelPrincipal.add(panelArtistas, BorderLayout.WEST);
        panelPrincipal.add(panelAlbums, BorderLayout.CENTER);
        panelPrincipal.add(panelSongs, BorderLayout.EAST);
        panelPrincipal.add(panelPlayStop, BorderLayout.SOUTH);
        
        // 4. Adicionar panel3 al JFrame y hacerlo visible
        //add(panelPrincipal);
        //setSize(600,300);
        //setVisible(true);
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public JPanel getPanel2()
    {
    	return this.panelPrincipal;
    }
    
    public void actionPerformed(ActionEvent e)
    {
    	if(e.getSource()==bCatalogo)
    	{
    		//JOptionPane.showMessageDialog(null, "Catálogo");
    		//1. Obtener los artistas del catálogo
    		vectorArtistas = itunesAD.obtenerArtistas();
    		listaArtistas = new JList(vectorArtistas);
    		listaArtistas.addListSelectionListener(this);
    		//2. Mostrar los artistas en el panel de artistas
    		//JOptionPane.showMessageDialog(null, vectorArtistas);
    		    		
    		
    		panelArtistas.setVisible(false);
    		panelArtistas.removeAll();
    		panelArtistas.add(listaArtistas);
    		panelArtistas.setVisible(true);
    		
    	}
    	
    	if(e.getSource()==bArtista)
    	{
    		String artist;
    		
    		artist = tfArtist.getText();
    		vectorArtistas = itunesAD.getArtist(artist);
    		listaArtistas = new JList<String>(vectorArtistas);
    		listaArtistas.addListSelectionListener(this);
    		
    		
    		if(artist.isEmpty()||vectorArtistas.isEmpty())
    		{
    			tfArtist.setText("Ingresa un artista...");
    		}
    		else
    		{    			
    			
	    		panelArtistas.setVisible(false);
	    		panelArtistas.removeAll();
	    		panelArtistas.add(listaArtistas);
	    		panelArtistas.setVisible(true);
    		}
    	}
    	
    	if(e.getSource()==bPlay)
    	{
    		audio.stop();
    		audio.reproducir(cancionElegida);
    		
    	
    	}
    	
    	if(e.getSource()==bStop)
    	{
    		//JOptionPane.showMessageDialog(null, "Stop");
    		audio.stop();
    	}
    	
    }
    
    public void valueChanged(ListSelectionEvent lse)
    {
    	if(lse.getValueIsAdjusting()==true)
    	{	if(lse.getSource()==listaArtistas)
	    	{
    			// 1. Seleccionar el artista de quien se desean los albums
	    		artistaElegido = (String)listaArtistas.getSelectedValue();
	    		System.out.println(artistaElegido);
	    		
	    		// 2. Obtener los albums del artista 
	    		vectorAlbums = itunesAD.obtenerAlbums(artistaElegido);
	    		listaAlbums = new JList(vectorAlbums);
	    		
	    		
	    		listaAlbums.addListSelectionListener(this);
	    		
	    		// 3. Mostrar los albums en el panel de albums
	    		//JOptionPane.showMessageDialog(null, vectorAlbums);
	    		panelAlbums.setVisible(false);
	    		panelAlbums.removeAll();
	    		panelAlbums.add(listaAlbums);
	    		panelAlbums.setVisible(true);
	    	}
    	
    		if(lse.getSource()==listaAlbums)
    		{
    			//1. Seleccionar el album
    			albumElegido = (String)listaAlbums.getSelectedValue();
    			System.out.println(albumElegido);
    			
    			// 2. Obtener las canciones del artista
    			vectorCanciones = itunesAD.obtenerCanciones(albumElegido);
    			listaSongs = new JList(vectorCanciones);
    			listaSongs.addListSelectionListener(this);
    			//3. Mostrar las canciones en el panel de canciones
    			panelSongs.setVisible(false);
    			panelSongs.removeAll();
    			panelSongs.add(listaSongs);
    			panelSongs.setVisible(true);
    			
    		}
    		
    		if(lse.getSource()==listaSongs)
    		{
    			//parar cancion anterior
    			audio.stop();
    			
    			//1. Seleccionar cancion a resproducir
    			cancionElegida = listaSongs.getSelectedValue();
    			System.out.println(cancionElegida);
    			    			
    			//2. Reproducir canción 
    			audio.reproducir(cancionElegida);
    			
    			//3. Mostrar la cancion en que se esta reproduciondo, en el panel
    			panelPlayStop.setVisible(false);
    			panelPlayStop.removeAll();
    			panelPlayStop.add(new JLabel("Now playing: "+ cancionElegida));
    			panelPlayStop.add(bPlay);
    	        panelPlayStop.add(bStop);
    			panelPlayStop.setVisible(true);
    			
    			
    			
    			
    		}
    	}    
    }   
    
   
    
    public static void main(String args[])
    {
        new ITunesGUI();
    }
}
