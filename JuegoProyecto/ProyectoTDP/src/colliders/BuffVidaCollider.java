package colliders;

import Naves.Jugador;
import buffs.BuffVida;

public class BuffVidaCollider extends DefaultCollider {
	
	public BuffVidaCollider() {
		super();
	}
	public void collideJugador(Jugador j) {
		j.addBuff(new BuffVida(0,0));
	}
}
