package colliders;

import disparos.DisparoEnemigo;
import naves.Enemigo;
import obstaculos.ObstaculoJugador;
import obstaculos.ObstaculoTodos;

public class SuperMisilCollider extends DefaultCollider {

	public SuperMisilCollider(int daño) {
		super(daño);
	}
	
	public void collideEnemigo(Enemigo e) {
		e.recibirDaño(daño);
	}
	
	public void collideDisparoEnemigo(DisparoEnemigo d) {
		d.morir();
	}

	public void collideObstaculoTodos(ObstaculoTodos o) {
		o.recibirDaño(daño);
	}
	
	public void collideObstaculoJugador(ObstaculoJugador o) {
		o.recibirDaño(daño);
	}
	

}
