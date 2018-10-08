package colliders;

import Naves.Enemigo;
import Naves.Entidad;
import obstaculos.Obstaculo;

public class DisparoCollider extends DefaultCollider {
	public DisparoCollider(Entidad e) {
		super(e);
	}
	
	public void collideEnemigo(Enemigo e) {
		//Hay que afectar al jugador cuando choca al enemigo
		e.morir();
		visitor.morir();
	}
	public void collideObstaculo(Obstaculo o) {
		o.morir();
		visitor.morir();
	}


}
