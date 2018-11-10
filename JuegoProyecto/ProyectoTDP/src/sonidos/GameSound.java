package sonidos;

import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public enum GameSound {
	EXPLOSION("/sonidos/Explosion.wav"), 
	DISPARO("/sonidos/Disparo2.wav"), 
	NO_BALAS("/sonidos/NoBalas.wav"), 
	DISPARO_ENEMIGO("/sonidos/DisparoEnemigo.wav"),
	POWER_UP("/sonidos/Power Up.wav"),
	DISPARO_LASER("/sonidos/Laser1.wav");

	private Clip[] myClips = new Clip[4];
	private int currentClip = 0;
	GameSound(String soundFileName) {
		try {

			for (int i = 0; i < myClips.length; i++) {
				// Set up an audio input stream piped from the sound file.
				AudioInputStream audioInputStream = AudioSystem
						.getAudioInputStream(this.getClass().getResource(soundFileName));
				// Get a clip resource.
				myClips[i] = AudioSystem.getClip();
				// Open audio clip and load samples from the audio input stream.
				myClips[i].open(audioInputStream);
			}
		} catch (UnsupportedAudioFileException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (LineUnavailableException e) {
			e.printStackTrace();
		}
	}

	public void play() {
		if (currentClip>=myClips.length)
			currentClip=0;
		myClips[currentClip].setFramePosition(0);
		myClips[currentClip].start();
		// Start playing
		currentClip++;
	}

	public void stop() {
		if (currentClip>=myClips.length)
			currentClip=0;
		if (myClips[currentClip].isRunning())
			myClips[currentClip].stop();
		currentClip++;
	}

	public static void init() {
		values();
	}
}
