import java.io.InputStream;

import javax.sound.sampled.AudioPermission;

import java.io.FileInputStream;
import java.nio.file.Paths;
import java.nio.file.Path;
import sun.audio.AudioStream;
import sun.audio.AudioPlayer;

public class AudioOS {

	InputStream streamCancion;
	AudioStream audioStream;
	
	public String reproducir(String song) //throws Exception
	{		
		String transaccion="";
		
		try
		{
			//1. Especificar el nombre de la canción a reproducir
			Path currentPath = Paths.get(System.getProperty("user.dir"));
			System.out.println("currentPath: " + currentPath);
			song += ".wav";
			Path filePath = Paths.get(currentPath.toString(), "songs", song);
			System.out.println("filePath: " + filePath);
			
			//2. Preparar los streams de audio
		    streamCancion = new FileInputStream(filePath.toString());
	 		
			//3. Preparar el AudioStream y 
			audioStream = new AudioStream(streamCancion);
			AudioPlayer.player.start(audioStream);
			
			transaccion="Now playing: "+song;
		}
		catch(Exception e)
		{
			transaccion="Now Playing: Error NO SONG";
			System.out.println("Error: "+e);
		}
		
		return transaccion;
		
	}
	
	public void stop()
	{
		AudioPlayer.player.stop(audioStream);
	}
	
	

}
