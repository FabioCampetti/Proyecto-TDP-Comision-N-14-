package inteligencias;

import java.awt.Point;

import javax.swing.JLabel;

import naves.Entidad;

public class IEnemigoBasico extends Inteligencia {
	private float mover;
	private static IEnemigoBasico instancia;

	private IEnemigoBasico() {
		super();
		mover = 0;
	}

	public static IEnemigoBasico getInstance() {
		if (instancia == null)
			return new IEnemigoBasico();
		return instancia;
	}

	public void mover(Entidad e) {
		JLabel pos = e.getPosicion();
		if (!e.isFrozen()) {
			Point a = MovParametrico.dondeMoverLemnis(pos, mover);
			pos.setLocation(a);
			mover += 0.1;
		}
	}
}
