package Disparos;
import Naves.Entidad;

public abstract class Disparo extends Entidad {
	int da�o;
	
	/**
	 * FALTAN DETALLES DE IMPLEMENTACION ETC.
	 */
	
	public Disparo() {
		super();
	}
	public int getDa�o() {
		return da�o;
	}
	public void setDa�o(int da�o) {
		this.da�o = da�o;
	}
}
