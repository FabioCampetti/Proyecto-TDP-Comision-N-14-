package colliders;

import disparos.DisparoEnemigo;
import naves.Enemigo;
import naves.EnemigoBoss;
import obstaculos.ObstaculoJugador;
import obstaculos.ObstaculoTodos;

public class DisparoCollider extends DefaultCollider {
	
	public DisparoCollider(int da�o) {
		super(da�o);
	}
	
	@Override
	public void collideEnemigo(Enemigo e) {
		e.recibirDa�o(da�o);
	}
	
	@Override
	public void collideObstaculoTodos(ObstaculoTodos o) {
		o.recibirDa�o(da�o);
	}
	
	@Override
	public void collideObstaculoJugador(ObstaculoJugador o) {
		o.recibirDa�o(da�o);
	}
	
	@Override
	public void collideDisparoEnemigo(DisparoEnemigo d) {
		d.morir();
	}
	
	@Override
	public void collideBoss(EnemigoBoss e) {
		e.recibirDa�o(da�o);
	}
}
