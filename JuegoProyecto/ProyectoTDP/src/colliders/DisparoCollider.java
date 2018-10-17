package colliders;

import Naves.Enemigo;
import obstaculos.*;

public class DisparoCollider extends DefaultCollider {
	
	public DisparoCollider(int da�o) {
		super(da�o);
	}
	
	public void collideEnemigo(Enemigo e) {
		e.recibirDa�o(da�o);
	}
	public void collideObstaculoTodos(ObstaculoTodos o) {
		o.recibirDa�o(da�o);
	}
	
	public void collideObstaculoJugador(ObstaculoJugador o) {
		o.recibirDa�o(da�o);
	}

}
