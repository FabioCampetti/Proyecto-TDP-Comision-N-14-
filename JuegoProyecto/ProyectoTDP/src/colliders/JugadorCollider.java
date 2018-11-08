package colliders;
import buffs.Buff;
import disparos.DisparoEnemigo;
import naves.Enemigo;
import naves.EnemigoBoss;
import obstaculos.ObstaculoJugador;
import obstaculos.ObstaculoTodos;

public class JugadorCollider extends DefaultCollider {
	public JugadorCollider(int daño) {
		super(daño);
	}
	
	public void collideEnemigo(Enemigo e) {
		e.recibirDaño(daño);
	}
	public void collideDisparoEnemigo(DisparoEnemigo d) {
		d.morir();
	}
	public void collideBuff(Buff b) {
		b.morir();
	}
	public void collideObstaculoJugador(ObstaculoJugador o) {
		o.recibirDaño(daño);
	}
	public void collideObstaculoTodos(ObstaculoTodos o) {
		o.morir();
	}
	public void collideBoss(EnemigoBoss e) {
		//El boss no recibe daño cuando es chocado por el jugador.
	}
}
