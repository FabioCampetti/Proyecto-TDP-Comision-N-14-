package colliders;

import disparos.DisparoJugador;
import naves.Jugador;

public class BossCollider extends DefaultCollider {

	public BossCollider(int da�o) {
		super(da�o);
	}

	@Override
	public void collideJugador(Jugador j) {
		j.recibirDa�o(da�o);
	}

	@Override
	public void collideDisparoJugador(DisparoJugador d) {
		d.morir();
	}

}
