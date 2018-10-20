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
/*
	Mover alternativo, mueve haciendo zig zag, lo dejo aca hasta que lo veamos.
	
private int sigMov;
	public IDisparoEstandar(int velocidad) {
		super(velocidad);
		sigMov=5;
	}

	public void mover(Entidad e) {
		JLabel pos= e.getPosicion();
		int x,y;
		y=pos.getY() - velocidad;
		x=pos.getX();
		if (sigMov<5) {
			x+=velocidad;
			sigMov++;
		}
		if (sigMov>=5) {
			x-=velocidad;
			sigMov++;
			}
		if (sigMov==10) {
			sigMov=0;
		}
		pos.setLocation(x,y);
		if (pos.getY()<0)
			e.morir();
	}
*/