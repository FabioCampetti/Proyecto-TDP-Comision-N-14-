package colliders;
import buffs.BuffTimerArma;
import disparos.ArmaJugadorTriple;
import naves.Jugador;
public class BuffArmaCollider extends DefaultCollider {
	
	public BuffArmaCollider() {
		super(0);
	}
	
	public void collideJugador(Jugador j) {
		j.cambiarArma(new ArmaJugadorTriple(j));
		j.addBuff(new BuffTimerArma());
	}
	
}
