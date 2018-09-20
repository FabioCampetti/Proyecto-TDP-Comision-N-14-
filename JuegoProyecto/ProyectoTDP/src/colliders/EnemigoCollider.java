package colliders;
import Naves.*;
import Disparos.*;
import obstaculos.*;

public class EnemigoCollider extends DefaultCollider {
	public void collideJugador(Jugador j) {
		//Hay que modelar que pasa cuando un enemigo choca al jugador
	}
	public void collideDisparoJugador(DisparoJugador d) {
		//Hay que modelar que pasa cuando un enemigo recibe un disparo del jugador
	}
	public void collideObstaculoTodos(ObstaculoTodos o) {
		//Hay que modelar que pasa cuando un enemigo choca con un obstaculo que lo afecte
	}
}
