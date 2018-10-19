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
<<<<<<< HEAD
		while (true) {
			//Si no pongo esto no anda ni idea por que
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
					gui.seguirJugando(mapa.getScore());
					break;
				}
				mapa.updateVida(mapa.getJugador().getVida());
				mapa.updateBuffs();
=======
		while(true){
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
>>>>>>> 8ee8d9796b6a98d9f2190b38bcc620759e7fd276
			}
		}
	}
	
	public boolean isPaused() {
		return running==false;
	}
	
	public void pause() {
		running = !running;
	}
}