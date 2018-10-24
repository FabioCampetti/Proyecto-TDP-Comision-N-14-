package colliders;
import Disparos.DisparoJugador;
import Naves.Jugador;
import obstaculos.ObstaculoTodos;

public class EnemigoCollider extends DefaultCollider {
	public EnemigoCollider(int daño) {
		super(daño);
	}
	
	public void collideJugador(Jugador j) {
		//Hay que modelar que pasa cuando un enemigo choca al jugador
		j.recibirDaño(daño);
	}
	public void collideDisparoJugador(DisparoJugador d) {
		d.morir();
	}
	public void collideObstaculoTodos(ObstaculoTodos o) {
		//Hay que modelar que pasa cuando un enemigo choca con un obstaculo que lo afecte
		o.morir();
	}
}
