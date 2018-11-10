package colliders;

import disparos.DisparoEnemigo;
import naves.Enemigo;
import naves.EnemigoBoss;
import obstaculos.ObstaculoJugador;
import obstaculos.ObstaculoTodos;

public class DisparoCollider extends DefaultCollider {
	
	public DisparoCollider(int daño) {
		super(daño);
	}
	
	@Override
	public void collideEnemigo(Enemigo e) {
		e.recibirDaño(daño);
	}
	
	@Override
	public void collideObstaculoTodos(ObstaculoTodos o) {
		o.recibirDaño(daño);
	}
	
	@Override
	public void collideObstaculoJugador(ObstaculoJugador o) {
		o.recibirDaño(daño);
	}
	
	@Override
	public void collideDisparoEnemigo(DisparoEnemigo d) {
		d.morir();
	}
	
	@Override
	public void collideBoss(EnemigoBoss e) {
		e.recibirDaño(daño);
	}
}
