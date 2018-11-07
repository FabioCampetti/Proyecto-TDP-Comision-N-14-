package colliders;

import buffs.BuffTimerVida;
import naves.Jugador;
import sonidos.GameSound;

public class BuffVidaCollider extends DefaultCollider {
	
	public BuffVidaCollider() {
		super(0);
	}
	public void collideJugador(Jugador j) {
		j.addBuff(new BuffTimerVida());
		GameSound.POWER_UP.play();
	}
}
