package inteligencias;

import javax.swing.JLabel;

import naves.Entidad;

public class IDisparoEstandar extends Inteligencia {

	@Override
	public void mover(Entidad e) {
		JLabel pos = e.getPosicion();
		int velocidad = e.getVelocidad();
		pos.setLocation(pos.getX(), pos.getY() - velocidad);
		if (pos.getY() < 0)
			e.morir();
	}

}