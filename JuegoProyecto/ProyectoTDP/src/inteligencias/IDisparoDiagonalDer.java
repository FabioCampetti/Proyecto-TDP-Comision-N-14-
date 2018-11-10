package inteligencias;

import javax.swing.JLabel;

import mapas.Mapa;
import naves.Entidad;

public class IDisparoDiagonalDer extends Inteligencia {

	@Override
	public void mover(Entidad e) {
		JLabel pos = e.getPosicion();
		int velocidad = e.getVelocidad();
		pos.setLocation(pos.getX() + velocidad, pos.getY() - velocidad);
		if (pos.getY() < 0 || pos.getX() > Mapa.ANCHO)
			e.morir();
	}

}
