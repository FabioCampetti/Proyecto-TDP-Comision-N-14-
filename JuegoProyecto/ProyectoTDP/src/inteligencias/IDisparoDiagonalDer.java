package inteligencias;

import javax.swing.JLabel;

import Mapas.Mapa;
import Naves.Entidad;

public class IDisparoDiagonalDer extends Inteligencia {

	public IDisparoDiagonalDer(int velocidad) {
		super(velocidad);
	}
	
	public void mover(Entidad e) {
		JLabel pos = e.getPosicion();
		pos.setLocation(pos.getX()+ velocidad,pos.getY() - velocidad);
		if (pos.getY()<0||pos.getX()>Mapa.ANCHO)
			e.morir();
	}
	
}
