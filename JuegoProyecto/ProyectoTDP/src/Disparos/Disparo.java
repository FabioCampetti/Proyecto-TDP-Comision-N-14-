package Disparos;
import Naves.Entidad;
import inteligencias.Inteligencia;

public abstract class Disparo extends Entidad {
	
	/**
	 * FALTAN DETALLES DE IMPLEMENTACION ETC.
	 */
	Inteligencia myInteligencia;
	
	public Disparo() {
		super();
	}
	
	public void cambiarInteligencia(Inteligencia i) {
		myInteligencia=i;
	}
}
