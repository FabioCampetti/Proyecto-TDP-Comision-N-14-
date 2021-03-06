package colliders;
import buffs.Buff;
import disparos.DisparoEnemigo;
import disparos.DisparoJugador;
import disparos.DisparoSuperMisil;
import naves.Enemigo;
import naves.EnemigoBoss;
import naves.Jugador;
import obstaculos.ObstaculoJugador;
import obstaculos.ObstaculoTodos;

public abstract class DefaultCollider {
	protected int da�o;
	public DefaultCollider(int da�o) {
		this.da�o=da�o;
	}
	
	public void collideBoss(EnemigoBoss e) {}
	public void collideEnemigo(Enemigo e) {}
	public void collideJugador(Jugador j) {}
	public void collideDisparoJugador(DisparoJugador d) {}
	public void collideDisparoEnemigo(DisparoEnemigo d) {}
	public void collideSuperMisil(DisparoSuperMisil d) {}
	public void collideObstaculoJugador(ObstaculoJugador o) {}
	public void collideObstaculoTodos(ObstaculoTodos o) {}
	public void collideBuff(Buff b) {}
}
