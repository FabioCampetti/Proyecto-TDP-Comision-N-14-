package colliders;

import disparos.DisparoJugador;
import naves.Jugador;

public class BossCollider extends DefaultCollider {

	public BossCollider(int daño) {
		super(daño);
	}

	@Override
	public void collideJugador(Jugador j) {
		j.recibirDaño(daño);
	}

	@Override
	public void collideDisparoJugador(DisparoJugador d) {
		d.morir();
	}

}
