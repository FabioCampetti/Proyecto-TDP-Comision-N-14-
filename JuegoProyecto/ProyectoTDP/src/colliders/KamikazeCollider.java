package colliders;
import Naves.*;
import Disparos.*;
import obstaculos.*;

public class KamikazeCollider extends DefaultCollider {
	public KamikazeCollider(int da�o) {
		super(da�o);
	}
	
	public void collideJugador(Jugador j) {
		//Hay que modelar que pasa cuando un enemigo choca al jugador
		j.recibirDa�o(da�o);
	}
	public void collideDisparoJugador(DisparoJugador d) {
		d.morir();
	}
	public void collideObstaculoTodos(ObstaculoTodos o) {
		//Hay que modelar que pasa cuando un enemigo choca con un obstaculo que lo afecte
	}
}
