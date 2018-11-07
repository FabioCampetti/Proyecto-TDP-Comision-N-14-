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
	
	public void collideEnemigo(Enemigo e) {
		e.recibirDa�o(da�o);
	}
	
	public void collideObstaculoTodos(ObstaculoTodos o) {
		o.recibirDa�o(da�o);
	}
	
	public void collideObstaculoJugador(ObstaculoJugador o) {
		o.recibirDa�o(da�o);
	}
	
	public void collideDisparoEnemigo(DisparoEnemigo d) {
		d.morir();
	}
	
	public void collideBoss(EnemigoBoss e) {
		e.recibirDa�o(da�o);
	}
}
