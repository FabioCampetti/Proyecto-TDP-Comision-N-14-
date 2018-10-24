package colliders;

import disparos.DisparoJugador;
import naves.Jugador;

public class ObstaculoJugadorCollider extends DefaultCollider {
	public ObstaculoJugadorCollider(int da�o) {
		super(da�o);
	}
	public void collideDisparoJugador(DisparoJugador d) {
		//Hay que modelar que le sucede al obstaculo cuando recibe un disparo de jugador.
		d.morir();
	}
	public void collideJugador(Jugador j) {
		j.recibirDa�o(da�o);
	}
}
