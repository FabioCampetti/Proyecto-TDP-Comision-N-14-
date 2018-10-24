package buffs;

import colliders.DefaultCollider;
import mapas.Mapa;
import naves.Entidad;

public abstract class Buff extends Entidad {
	public final int ancho=80;
	public final int alto=80;
	
	public void mover(int x) {
		pos.setLocation(pos.getX(),pos.getY()+velocidad);
		if (pos.getY()>Mapa.ALTO)
			this.morir();
	}
	public void colision(Entidad e) {
		e.aceptar(myCollider);
	}
	
	public void aceptar(DefaultCollider c) {
		c.collideBuff(this);
	}
}
