package colliders;
import buffs.Buff;
import disparos.DisparoEnemigo;
import disparos.DisparoJugador;
import naves.Enemigo;
import naves.Jugador;
import obstaculos.ObstaculoJugador;
import obstaculos.ObstaculoTodos;

public abstract class DefaultCollider {
	protected int daño;
	public DefaultCollider(int daño) {
		this.daño=daño;
	}
	
	public void collideEnemigo(Enemigo e) {}
	public void collideJugador(Jugador j) {}
	public void collideDisparoJugador(DisparoJugador d) {}
	public void collideDisparoEnemigo(DisparoEnemigo d) {}
	public void collideObstaculoJugador(ObstaculoJugador o) {}
	public void collideObstaculoTodos(ObstaculoTodos o) {}
	public void collideBuff(Buff b) {}
}
