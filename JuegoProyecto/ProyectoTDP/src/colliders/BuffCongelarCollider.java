package colliders;

import Naves.Jugador;
import buffs.BuffTimerCongelar;

public class BuffCongelarCollider extends DefaultCollider {
	public BuffCongelarCollider(int daño) {
		super(daño);
	}
	public void collideJugador(Jugador j) {
		j.addBuff(new BuffTimerCongelar());
	}
}
