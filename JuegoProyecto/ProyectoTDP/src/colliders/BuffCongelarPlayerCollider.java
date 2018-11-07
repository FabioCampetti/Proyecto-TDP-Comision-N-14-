package colliders;

import buffs.BuffTimerCongelarPlayer;
import naves.Jugador;
import sonidos.GameSound;

public class BuffCongelarPlayerCollider extends DefaultCollider{

	public BuffCongelarPlayerCollider() {
		super(0);
	}
	
	public void collideJugador(Jugador j) {
		j.addBuff(new BuffTimerCongelarPlayer());
		GameSound.POWER_UP.play();
	}
	
}
