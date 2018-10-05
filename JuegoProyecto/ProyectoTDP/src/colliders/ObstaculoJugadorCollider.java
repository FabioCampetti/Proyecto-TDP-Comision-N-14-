package colliders;

import Disparos.DisparoJugador;
import Naves.Entidad;

public class ObstaculoJugadorCollider extends DefaultCollider {
	public ObstaculoJugadorCollider(Entidad e) {
		super(e);
	}
	public void collideDisparo(DisparoJugador d) {
		//Hay que modelar que le sucede al obstaculo cuando recibe un disparo de jugador.
	}
}
