package Disparos;
import Naves.Entidad;

public abstract class Disparo extends Entidad {
	int daño;
	
	/**
	 * FALTAN DETALLES DE IMPLEMENTACION ETC.
	 */
	
	public Disparo() {
		super();
	}
	public int getDaño() {
		return daño;
	}
	public void setDaño(int daño) {
		this.daño = daño;
	}
}
