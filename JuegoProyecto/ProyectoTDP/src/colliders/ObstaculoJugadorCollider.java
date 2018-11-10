package colliders;

import disparos.DisparoJugador;
import naves.Jugador;

public class ObstaculoJugadorCollider extends DefaultCollider {
	public ObstaculoJugadorCollider(int da�o) {
		super(da�o);
	}
	@Override
	public void collideDisparoJugador(DisparoJugador d) {
		d.morir();
	}
	@Override
	public void collideJugador(Jugador j) {
		j.recibirDa�o(da�o);
	}
}
