package colliders;

import disparos.DisparoEnemigo;
import naves.Enemigo;
import obstaculos.ObstaculoJugador;
import obstaculos.ObstaculoTodos;

public class SuperMisilCollider extends DefaultCollider {

	public SuperMisilCollider(int da�o) {
		super(da�o);
	}
	
	@Override
	public void collideEnemigo(Enemigo e) {
		e.recibirDa�o(da�o);
	}
	
	@Override
	public void collideDisparoEnemigo(DisparoEnemigo d) {
		d.morir();
	}

	@Override
	public void collideObstaculoTodos(ObstaculoTodos o) {
		o.recibirDa�o(da�o);
	}
	
	@Override
	public void collideObstaculoJugador(ObstaculoJugador o) {
		o.recibirDa�o(da�o);
	}
	

}
