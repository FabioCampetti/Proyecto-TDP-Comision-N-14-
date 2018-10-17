package colliders;
import Naves.*;
import Disparos.*;
import buffs.*;
import obstaculos.*;

public abstract class DefaultCollider {
	protected int da�o;
	public DefaultCollider(int da�o) {
		this.da�o=da�o;
	}
	
	public void collideEnemigo(Enemigo e) {}
	public void collideJugador(Jugador j) {}
	public void collideDisparoJugador(DisparoJugador d) {}
	public void collideDisparoEnemigo(DisparoEnemigo d) {}
	public void collideObstaculoJugador(ObstaculoJugador o) {}
	public void collideObstaculoTodos(ObstaculoTodos o) {}
	public void collideBuff(Buff b) {}
}
