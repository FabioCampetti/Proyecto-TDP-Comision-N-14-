package colliders;
import Naves.*;
import Disparos.*;
import buffs.*;
import obstaculos.ObstaculoJugador;
import obstaculos.ObstaculoTodos;

public class JugadorCollider extends DefaultCollider {
	public JugadorCollider(int da�o) {
		super(da�o);
	}
	
	public void collideEnemigo(Enemigo e) {
		//Hay que afectar al jugador cuando choca al enemigo
		e.recibirDa�o(da�o);
	}
	public void collideDisparoEnemigo(DisparoEnemigo d) {
		//Hay que afectar al jugador cuando recibe un disparo enemigo
		d.morir();
	}
	public void collideBuff(Buff b) {
		//Hay que afectar al jugador cuando lo choca un buff
		b.morir();
	}
	public void collideObstaculoJugador(ObstaculoJugador o) {
		o.recibirDa�o(da�o);
		//visitor.getPosicion().setlocation(visitor.getPosicion().getX(), visitor.getPosicion().getY()+30);
	}
	public void collideObstaculoTodos(ObstaculoTodos o) {
		o.recibirDa�o(da�o);
		
		//visitor.getPosicion().setLocation(visitor.getPosicion().getX(), visitor.getPosicion().getY()+30);
	}
}
