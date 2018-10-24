package colliders;
import Disparos.DisparoJugador;
import Naves.Jugador;
import obstaculos.ObstaculoTodos;

public class EnemigoCollider extends DefaultCollider {
	public EnemigoCollider(int da�o) {
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
		o.morir();
	}
}
