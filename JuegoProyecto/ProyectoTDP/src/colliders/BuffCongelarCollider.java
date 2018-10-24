package colliders;

import buffs.BuffTimerCongelar;
import naves.Jugador;

public class BuffCongelarCollider extends DefaultCollider {
	public BuffCongelarCollider(int da�o) {
		super(da�o);
	}
	public void collideJugador(Jugador j) {
		j.addBuff(new BuffTimerCongelar());
	}
}
