package colliders;
import Disparos.ArmaJugadorTriple;
import Naves.*;
public class BuffArmaCollider extends DefaultCollider {
	public BuffArmaCollider(int da�o) {
		super(da�o);
	}
	public void collideJugador(Jugador j) {
		//Hay que modelar que sucede cuando un buff colisiona con el jugador.
		j.cambiarArma(new ArmaJugadorTriple(j));
	}
}
