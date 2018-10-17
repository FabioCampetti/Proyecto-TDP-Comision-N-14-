package colliders;

import Naves.Enemigo;
import obstaculos.*;

public class DisparoCollider extends DefaultCollider {
	
	public DisparoCollider() {
		super();
	}
	
	public void collideEnemigo(Enemigo e) {
		e.morir();
	}
	public void collideObstaculoTodos(ObstaculoTodos o) {
		o.morir();
	}
	
	public void collideObstaculoJugador(ObstaculoJugador o) {
		o.morir();
	}

}
