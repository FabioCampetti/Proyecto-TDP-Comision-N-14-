package colliders;

import buffs.BuffTimerCongelar;
import naves.Jugador;

public class BuffCongelarCollider extends DefaultCollider {
	public BuffCongelarCollider(int daño) {
		super(daño);
	}
	public void collideJugador(Jugador j) {
		j.addBuff(new BuffTimerCongelar());
	}
}
