package colliders;
import Naves.*;
import Disparos.*;
import obstaculos.*;

public class EnemigoCollider extends DefaultCollider {
	public EnemigoCollider() {
		super();
	}
	
	public void collideJugador(Jugador j) {
		//Hay que modelar que pasa cuando un enemigo choca al jugador
		j.recibirDaņo(10);
	}
	public void collideDisparoJugador(DisparoJugador d) {
		d.morir();
	}
	public void collideObstaculoTodos(ObstaculoTodos o) {
		//Hay que modelar que pasa cuando un enemigo choca con un obstaculo que lo afecte
	}
}
