package Disparos;
import java.util.Collection;

import Naves.Entidad;

public abstract class Arma {
	protected Entidad quienDisparo;
	public abstract Collection<Disparo> disparar();
}
