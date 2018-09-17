package colliders;
import Naves.*;
import Disparos.*;
import buffs.*;
import obstaculos.*;

public abstract class DefaultCollider {
	public void collideEnemigo(Enemigo e) {}
	public void collideJugador(Jugador j) {}
	public void collideDisparo(DisparoJugador d) {}
	public void collideDisparo(DisparoEnemigo d) {}
	public void collideObstaculoJugador(ObstaculoJugador o) {}
	public void collideObstaculoTodos(ObstaculoTodos o) {}
	public void collideBuff(Buff b) {}
}
