package inteligencias;

import javax.swing.JLabel;

import mapas.Mapa;
import naves.EnemigoArmado;
import naves.Entidad;

public class IEnemigoBasico extends Inteligencia {
	private int mover;

	public IEnemigoBasico() {
		super();
		mover = 0;
	}

	public void mover(Entidad e) {
		JLabel pos = e.getPosicion();
		int velocidad = e.getVelocidad();
		if (mover < 12) {
			if (pos.getX() < Mapa.ANCHO - EnemigoArmado.ancho)
				pos.setLocation(pos.getX() + velocidad, pos.getY());
			mover++;
			if (mover == 12)
				mover = 24;
		}

		if (mover > 12) {
			if (pos.getX() > 25)
				pos.setLocation(pos.getX() - velocidad, pos.getY());
			mover--;
			if (mover == 12)
				mover = 0;
		}

	}
}
