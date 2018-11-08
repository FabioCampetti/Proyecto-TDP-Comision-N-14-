package colliders;
import disparos.DisparoJugador;
import naves.Jugador;
import obstaculos.ObstaculoTodos;

public class KamikazeCollider extends DefaultCollider {
	public KamikazeCollider(int da�o) {
		super(da�o);
	}
	
	public void collideJugador(Jugador j) {
		j.recibirDa�o(da�o);
	}
	public void collideDisparoJugador(DisparoJugador d) {
		d.morir();
	}
	public void collideObstaculoTodos(ObstaculoTodos o) {
		o.morir();
	}
}
