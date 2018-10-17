package colliders;
import Naves.*;
import Disparos.*;
import obstaculos.*;

public class KamikazeCollider extends DefaultCollider {
	public KamikazeCollider(int daño) {
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
	}
}
