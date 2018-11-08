package colliders;
import disparos.DisparoJugador;
import naves.Jugador;
import obstaculos.ObstaculoTodos;

public class KamikazeCollider extends DefaultCollider {
	public KamikazeCollider(int daño) {
		super(daño);
	}
	
	public void collideJugador(Jugador j) {
		j.recibirDaño(daño);
	}
	public void collideDisparoJugador(DisparoJugador d) {
		d.morir();
	}
	public void collideObstaculoTodos(ObstaculoTodos o) {
		o.morir();
	}
}
