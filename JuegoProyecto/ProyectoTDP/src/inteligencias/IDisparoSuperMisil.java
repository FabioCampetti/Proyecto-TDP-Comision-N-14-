package inteligencias;

import javax.swing.JLabel;

import naves.Entidad;

public class IDisparoSuperMisil extends Inteligencia {
	float aceleracion=1;

	@Override

	public void mover(Entidad e) {
		
		JLabel pos = e.getPosicion();
		int velocidad = (int) (aceleracion * e.getVelocidad());
		pos.setLocation(pos.getX(), pos.getY() - velocidad);
		if (pos.getY() < 0)
			e.morir();
		aceleracion*=1.1;
	}

}
