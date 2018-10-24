package inteligencias;

import javax.swing.JLabel;

import naves.Entidad;

public class IDisparoDiagonalIzq extends Inteligencia {

	public void mover(Entidad e) {
		JLabel pos = e.getPosicion();
		int velocidad=e.getVelocidad();
		pos.setLocation(pos.getX()- velocidad,pos.getY() - velocidad);
		if (pos.getY()<0||pos.getX()<0)
			e.morir();
	}
}
