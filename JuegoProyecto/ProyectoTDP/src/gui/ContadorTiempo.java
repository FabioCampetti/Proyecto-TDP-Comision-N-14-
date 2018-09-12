package gui;

import Mapas.*;

public class ContadorTiempo extends Thread {

	private Mapa mapa;
	private GUI gui;

	ContadorTiempo(Mapa j, GUI gui) {
		this.mapa = j;
		this.gui = gui;
	}

	public void run() {
		while(true){
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			mapa.moveEnemigos();
			
		}
	}
}