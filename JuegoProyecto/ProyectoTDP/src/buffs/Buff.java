package buffs;

import Naves.Entidad;
import colliders.DefaultCollider;

public abstract class Buff extends Entidad {
	public void mover(int x) {
	}
	public void colision(Entidad e) {
		e.aceptar(myCollider);
	}
	
	public void aceptar(DefaultCollider c) {
		c.collideBuff(this);
	}
}
