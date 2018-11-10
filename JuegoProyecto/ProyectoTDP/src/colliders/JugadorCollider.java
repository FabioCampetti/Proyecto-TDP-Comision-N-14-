package colliders;
import buffs.Buff;
import disparos.DisparoEnemigo;
import naves.Enemigo;
import naves.EnemigoBoss;
import obstaculos.ObstaculoJugador;
import obstaculos.ObstaculoTodos;

public class JugadorCollider extends DefaultCollider {
	public JugadorCollider(int da�o) {
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
	public void collideBuff(Buff b) {
		b.morir();
	}
	@Override
	public void collideObstaculoJugador(ObstaculoJugador o) {
		o.recibirDa�o(da�o);
	}
	@Override
	public void collideObstaculoTodos(ObstaculoTodos o) {
		o.morir();
	}
	@Override
	public void collideBoss(EnemigoBoss e) {
		//El boss no recibe da�o cuando es chocado por el jugador.
	}
}
