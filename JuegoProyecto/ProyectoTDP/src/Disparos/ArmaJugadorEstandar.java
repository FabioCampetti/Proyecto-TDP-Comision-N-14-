package Disparos;
import java.util.Collection;
import java.util.LinkedList;
import Naves.Entidad;
import Naves.Jugador;

public class ArmaJugadorEstandar extends Arma {
	
	public ArmaJugadorEstandar(Entidad e) {
		quienDisparo=e;
	}
	public Collection<Disparo> disparar() {
		Collection<Disparo> disparos=new LinkedList<Disparo>();
		int val=(int) (Jugador.ancho*0.5);
		disparos.add(new DisparoJugador(quienDisparo.getPosicion().getX()+val, quienDisparo.getPosicion().getY() ));
		return disparos;
	}

}
