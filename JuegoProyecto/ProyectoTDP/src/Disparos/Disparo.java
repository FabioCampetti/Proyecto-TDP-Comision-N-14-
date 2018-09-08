package Disparos;
import Naves.Entidad;

public abstract class Disparo extends Entidad {
	int daño,velocidad;
	
	/**
	 * FALTAN DETALLES DE IMPLEMENTACION ETC.
	 */
	
	public Disparo(int x,int y) {
		super();
		this.pos.setBounds(x, y,250,250);
	}	

	
}
