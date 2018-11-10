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

	@Override
	public void run() {
		boolean finishThread = false;
		while (!finishThread) {
			try {
				sleep(20);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			if (running) {
				mapa.checkDisparos();
				mapa.moveEntidades();
				mapa.dispararEntidades();
				mapa.checkCollisions();
				mapa.checkExplosiones();
				mapa.updateVida();
				mapa.updateBuffs();
				
				if (mapa.youLost()) {
					mapa.removeAll();
					gui.menuPerder();
					finishThread = true;
				}
				
				if (mapa.youWon()) {
					gui.menuGanar();
					finishThread = true;
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