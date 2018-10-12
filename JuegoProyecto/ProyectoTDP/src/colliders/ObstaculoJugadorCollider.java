package colliders;

import Disparos.DisparoJugador;
import Naves.Jugador;

public class ObstaculoJugadorCollider extends DefaultCollider {
	public ObstaculoJugadorCollider() {
		super();
	}
	public void collideDisparoJugador(DisparoJugador d) {
		//Hay que modelar que le sucede al obstaculo cuando recibe un disparo de jugador.
		d.morir();
	}
	public void collideJugador(Jugador j) {
		j.setVida(j.getVida()-10);
	}
}
