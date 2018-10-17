package buffs;

import Naves.Entidad;
import colliders.DefaultCollider;

public abstract class Buff extends Entidad {
	public static final int ancho=80;
	public static final int alto=80;
	public void mover(int x) {
		pos.setLocation(pos.getX(),pos.getY()+velocidad);
	}
	public void colision(Entidad e) {
		e.aceptar(myCollider);
	}
	
	public void aceptar(DefaultCollider c) {
		c.collideBuff(this);
	}
}
