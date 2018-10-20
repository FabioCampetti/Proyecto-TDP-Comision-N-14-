package Disparos;
import java.util.Collection;

import Naves.Entidad;

public abstract class Arma {
	protected Entidad quienDisparo;
	protected int disparosRestantes;
	public abstract Collection<Disparo> disparar();
	public abstract void recargar();
	
	public int disparosRestantes() {
		return disparosRestantes;
	}
	
}
