package colliders;
import disparos.DisparoJugador;
import naves.Jugador;
import obstaculos.ObstaculoTodos;

public class EnemigoCollider extends DefaultCollider {
	public EnemigoCollider(int daño) {
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
