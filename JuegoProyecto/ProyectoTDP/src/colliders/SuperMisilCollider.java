package colliders;

import disparos.DisparoEnemigo;
import naves.Enemigo;
import obstaculos.ObstaculoJugador;
import obstaculos.ObstaculoTodos;

public class SuperMisilCollider extends DefaultCollider {

	public SuperMisilCollider(int daño) {
		super(daño);
	}
	
	@Override
	public void collideEnemigo(Enemigo e) {
		e.recibirDaño(daño);
	}
	
	@Override
	public void collideDisparoEnemigo(DisparoEnemigo d) {
		d.morir();
	}

	@Override
	public void collideObstaculoTodos(ObstaculoTodos o) {
		o.recibirDaño(daño);
	}
	
	@Override
	public void collideObstaculoJugador(ObstaculoJugador o) {
		o.recibirDaño(daño);
	}
	

}
