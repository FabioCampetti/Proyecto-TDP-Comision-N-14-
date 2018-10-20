package colliders;

import Naves.Jugador;
import buffs.BuffTimerVida;

public class BuffVidaCollider extends DefaultCollider {
	
	public BuffVidaCollider() {
		super(0);
	}
	public void collideJugador(Jugador j) {
		j.addBuff(new BuffTimerVida());
	}
}
