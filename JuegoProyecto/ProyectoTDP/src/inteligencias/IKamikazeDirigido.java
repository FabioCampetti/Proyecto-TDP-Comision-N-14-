package inteligencias;

import javax.swing.JLabel;

public class IKamikazeDirigido extends Inteligencia {
	//720 700
	private static final int posX = 720;
	private static final int posY = 700;
	
	public IKamikazeDirigido() {
		super();
	}
	/**
	 * INTELIGENCIAS CONOZCAN A JUGADOR PARA DIRIGIRSE HACIA EL? O QUE TODOS LOS ENEMIGOS SEPAN DONDE ESTA
	 * JUGADOR Y SE LO PASEN COMO PARAMETRO A LA INTELIGENCIA CADA VEZ QUE SE MUEVE.
	 */
	public void mover(JLabel pos) {
		while(pos.getX() != posX && pos.getY() != posY) {
			pos.setLocation(pos.getX() + 15, pos.getY() + 15);
		}
	}
}
