package gui;

import Mapas.*;

public class ContadorTiempo extends Thread {

	private Mapa mapa;
	private GUI gui;
	private boolean running;

	ContadorTiempo(Mapa j, GUI gui) {
		this.mapa = j;
		this.gui = gui;
		running = true;
	}

	public void run() {

		while (true) {
			// Si no pongo esto no anda ni idea por que
			System.out.println("");
			if (running) {
				try {
					sleep(50);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				mapa.checkDisparos();
				mapa.moveEntidades();
				mapa.dispararEntidades();
				if (mapa.checkCollisions()) {
					mapa.removeAll();
					mapa.repaint();
					gui.menuPerder(mapa.getScore());
					break;
				}
				mapa.updateVida();
				mapa.updateBuffs();
			}
		}
	}

	public boolean isPaused() {
		return running == false;
	}

	public void pause() {
		running = !running;
	}
}