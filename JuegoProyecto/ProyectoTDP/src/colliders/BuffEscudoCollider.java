package colliders;

import buffs.BuffTimerEscudo;
import escudos.EscudoIndestructible;
import naves.Jugador;

public class BuffEscudoCollider extends DefaultCollider {

	public BuffEscudoCollider(int da�o) {
		super(da�o);
	}
	
	public void collideJugador(Jugador j) {
		j.setEscudo(new EscudoIndestructible());
		j.addBuff(new BuffTimerEscudo());
		j.setImagenesEscudo();
	}

}
