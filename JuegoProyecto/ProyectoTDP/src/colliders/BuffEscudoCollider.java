package colliders;

import Escudos.EscudoIndestructible;
import Naves.Jugador;
import buffs.BuffTimerEscudo;

public class BuffEscudoCollider extends DefaultCollider {

	public BuffEscudoCollider(int daño) {
		super(daño);
	}
	
	public void collideJugador(Jugador j) {
		j.setEscudo(new EscudoIndestructible());
		j.addBuff(new BuffTimerEscudo());
	}

}
