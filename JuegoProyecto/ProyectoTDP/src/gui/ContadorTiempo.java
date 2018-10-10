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
				sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			mapa.checkDisparos();
			mapa.moveEntidades();
			mapa.checkCollisions();
		}
	}
}