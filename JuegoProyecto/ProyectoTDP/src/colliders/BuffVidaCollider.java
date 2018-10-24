package colliders;

import buffs.BuffTimerVida;
import naves.Jugador;

public class BuffVidaCollider extends DefaultCollider {
	
	public BuffVidaCollider() {
		super(0);
	}
	public void collideJugador(Jugador j) {
		j.addBuff(new BuffTimerVida());
	}
}
