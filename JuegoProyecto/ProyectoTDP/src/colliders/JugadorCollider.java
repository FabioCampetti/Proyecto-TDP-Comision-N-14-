package colliders;
import Naves.*;
import Disparos.*;
import buffs.*;

public class JugadorCollider extends DefaultCollider {
	public void collideEnemigo(Enemigo e) {
		//Hay que afectar al jugador cuando choca al enemigo
	}
	public void collideDisparo(DisparoEnemigo d) {
		//Hay que afectar al jugador cuando recibe un disparo enemigo
	}
	public void collideBuff(Buff b) {
		//Hay que afectar al jugador cuando lo choca un buff
	}
}
