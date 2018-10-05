package colliders;
import Naves.*;
import Disparos.*;
import buffs.*;

public class JugadorCollider extends DefaultCollider {
	public JugadorCollider(Entidad e) {
		super(e);
	}
	
	public void collideEnemigo(Enemigo e) {
		//Hay que afectar al jugador cuando choca al enemigo
		e.morir();
		visitor.morir();
	}
	public void collideDisparoEnemigo(DisparoEnemigo d) {
		//Hay que afectar al jugador cuando recibe un disparo enemigo
	}
	public void collideBuff(Buff b) {
		//Hay que afectar al jugador cuando lo choca un buff
	}
}
