package colliders;

import Naves.Enemigo;
import obstaculos.*;

public class DisparoCollider extends DefaultCollider {
	public DisparoCollider() {
		super();
	}
	
	public void collideEnemigo(Enemigo e) {
		//Hay que afectar al jugador cuando choca al enemigo
		e.morir();
	}
	public void collideObstaculoTodos(ObstaculoTodos o) {
		o.morir();
	}
	
	public void collideObstaculoJugador(ObstaculoJugador o) {
		o.morir();
	}


}
