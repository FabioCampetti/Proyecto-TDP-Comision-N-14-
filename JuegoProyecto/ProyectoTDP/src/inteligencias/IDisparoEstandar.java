package inteligencias;

import javax.swing.JLabel;

import Disparos.Disparo;
import Naves.Entidad;

public class IDisparoEstandar extends Inteligencia {

	public IDisparoEstandar(int velocidad) {
		super(velocidad);
		
	}

	public void mover(Entidad e) {
		JLabel pos= e.getPosicion();
		pos.setLocation(pos.getX(),pos.getY() - velocidad);
		if (pos.getY()<0)
			e.morir();
	}
	
}
