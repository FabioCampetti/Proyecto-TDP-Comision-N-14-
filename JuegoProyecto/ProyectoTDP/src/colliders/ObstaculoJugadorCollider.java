package colliders;

import disparos.DisparoJugador;
import naves.Jugador;

public class ObstaculoJugadorCollider extends DefaultCollider {
	public ObstaculoJugadorCollider(int daño) {
		super(daño);
	}
	@Override
	public void collideDisparoJugador(DisparoJugador d) {
		d.morir();
	}
	@Override
	public void collideJugador(Jugador j) {
		j.recibirDaño(daño);
	}
}
