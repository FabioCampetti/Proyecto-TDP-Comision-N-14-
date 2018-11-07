package sonidos;


import java.io.*;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public enum MusicSound {
	MUSICA_INTRO("/sonidos/Intro.wav"),
	MUSICA_JUEGO("/sonidos/MusicaJuego.wav");

	private Clip myClip;

	MusicSound(String soundFileName) {
		try {
			// Set up an audio input stream piped from the sound file.
			AudioInputStream audioInputStream = AudioSystem
					.getAudioInputStream(this.getClass().getResource(soundFileName));
			// Get a clip resource.
			myClip = AudioSystem.getClip();
			// Open audio clip and load samples from the audio input stream.
			myClip.open(audioInputStream);
		} catch (UnsupportedAudioFileException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (LineUnavailableException e) {
			e.printStackTrace();
		}
	}
	
	public void stop() {
		if (myClip.isRunning())
			myClip.stop();
	}
	
	public void playLoop() {
		myClip.setFramePosition(0);
		myClip.loop(Clip.LOOP_CONTINUOUSLY);
	}
	
	public static void init() {
		values();
	}
}

