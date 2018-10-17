package colliders;
import Disparos.ArmaJugadorTriple;
import Naves.*;
import buffs.BuffArma;
public class BuffArmaCollider extends DefaultCollider {
	public BuffArmaCollider() {
		super(0);
	}
	public void collideJugador(Jugador j) {
		//Hay que modelar que sucede cuando un buff colisiona con el jugador.
		j.cambiarArma(new ArmaJugadorTriple(j));
		j.addBuff(new BuffArma(0,0));
	}
}
