package colliders;

import Escudos.EscudoIndestructible;
import Naves.Jugador;
import buffs.BuffTimerEscudo;

public class BuffEscudoCollider extends DefaultCollider {

	public BuffEscudoCollider(int da�o) {
		super(da�o);
	}
	
	public void collideJugador(Jugador j) {
		j.setEscudo(new EscudoIndestructible());
		j.addBuff(new BuffTimerEscudo());
	}

}
