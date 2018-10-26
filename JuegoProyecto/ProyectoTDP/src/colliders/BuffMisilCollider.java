package colliders;

import buffs.BuffTimerArma;
import disparos.ArmaSuperMisil;
import naves.Jugador;

public class BuffMisilCollider extends DefaultCollider {

	public BuffMisilCollider() {
		super(0);
	}
	
	public void collideJugador(Jugador j) {
		j.cambiarArma(new ArmaSuperMisil(j));
		j.addBuff(new BuffTimerArma());
	}

}
