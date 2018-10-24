package disparos;
import inteligencias.Inteligencia;
import naves.Entidad;

public abstract class Disparo extends Entidad {
	
	protected Inteligencia myInteligencia;
	
	public void cambiarInteligencia(Inteligencia i) {
		myInteligencia=i;
	}
}
