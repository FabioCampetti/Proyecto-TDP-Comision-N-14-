package colliders;
import Naves.*;
import Disparos.*;
import buffs.*;
import obstaculos.ObstaculoJugador;
import obstaculos.ObstaculoTodos;

public class JugadorCollider extends DefaultCollider {
	public JugadorCollider() {
		super();
	}
	
	public void collideEnemigo(Enemigo e) {
		//Hay que afectar al jugador cuando choca al enemigo
		e.morir();
	}
	public void collideDisparoEnemigo(DisparoEnemigo d) {
		//Hay que afectar al jugador cuando recibe un disparo enemigo
	}
	public void collideBuff(Buff b) {
		//Hay que afectar al jugador cuando lo choca un buff
	}
	public void collideObstaculoJugador(ObstaculoJugador o) {
		o.morir();
		//visitor.getPosicion().setLocation(visitor.getPosicion().getX(), visitor.getPosicion().getY()+30);
	}
	public void collideObstaculoTodos(ObstaculoTodos o) {
		o.morir();
		
		//visitor.getPosicion().setLocation(visitor.getPosicion().getX(), visitor.getPosicion().getY()+30);
	}
}
