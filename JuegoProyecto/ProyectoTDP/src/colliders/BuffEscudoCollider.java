package colliders;

import buffs.BuffTimerEscudo;
import escudos.EscudoIndestructible;
import naves.Jugador;
import sonidos.GameSound;

public class BuffEscudoCollider extends DefaultCollider {

	public BuffEscudoCollider(int daño) {
		super(daño);
	}
	
	public void collideJugador(Jugador j) {
		j.setEscudo(new EscudoIndestructible());
		j.addBuff(new BuffTimerEscudo());
		j.setImagenesEscudo();
		GameSound.POWER_UP.play();
	}

}
