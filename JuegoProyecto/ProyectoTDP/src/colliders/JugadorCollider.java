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
		//Hay que afectar al jugador cuando choca al enemigo
		e.recibirDaño(daño);
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
		//visitor.getPosicion().setlocation(visitor.getPosicion().getX(), visitor.getPosicion().getY()+30);
		o.morir();
	}
	public void collideObstaculoTodos(ObstaculoTodos o) {
		o.morir();
		
		//visitor.getPosicion().setLocation(visitor.getPosicion().getX(), visitor.getPosicion().getY()+30);
	}
	public void collideBoss(EnemigoBoss e) {
		//Aca va que le pasa al boss cuando choca al jugador.
	}
}
