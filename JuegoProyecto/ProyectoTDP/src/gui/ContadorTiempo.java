package gui;

import mapas.Mapa;

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
			try {
				sleep(20);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			if (running) {	
				mapa.checkDisparos();
				mapa.moveEntidades();
				mapa.dispararEntidades();
				if (mapa.checkCollisions()) {
					mapa.removeAll();
					gui.menuPerder();
					break;
				}
				mapa.updateVida();
				mapa.updateBuffs();
				if (mapa.youWon()) {
					gui.menuGanar();
					break;
				}
				mapa.repaint();
			}
			
		}
	}

	public boolean isPaused() {
		return !running;
	}

	public void pause() {
		running = !running;
	}
}