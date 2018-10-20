package inteligencias;

import javax.swing.JLabel;

import Naves.Entidad;

public class IDisparoDiagonalIzq extends Inteligencia {

	public IDisparoDiagonalIzq(int velocidad) {
		super(velocidad);
		
	}

	public void mover(Entidad e) {
		JLabel pos = e.getPosicion();
		pos.setLocation(pos.getX()- velocidad,pos.getY() - velocidad);
		if (pos.getY()<0||pos.getX()<0)
			e.morir();
	}
}
