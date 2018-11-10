package colliders;

import buffs.BuffTimerArma;
import disparos.ArmaJugadorTriple;
import naves.Jugador;
import sonidos.GameSound;

public class BuffArmaCollider extends DefaultCollider {

	public BuffArmaCollider() {
		super(0);
	}

	@Override
	public void collideJugador(Jugador j) {
		j.cambiarArma(new ArmaJugadorTriple(j));
		j.addBuff(new BuffTimerArma());
		GameSound.POWER_UP.play();
	}

}
