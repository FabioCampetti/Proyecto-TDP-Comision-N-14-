package Disparos;
import Naves.Entidad;

public abstract class Disparo extends Entidad {
	int daño;
	private static final int ancho = 82;
	private static final int largo= 84;
	/**
	 * FALTAN DETALLES DE IMPLEMENTACION ETC.
	 */
	
	public Disparo(int x,int y) {
		super();
		this.pos.setBounds(x, y,ancho,largo);
	}		
}
