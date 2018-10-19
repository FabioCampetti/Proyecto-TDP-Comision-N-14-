package buffs;

import Mapas.Mapa;
import Naves.Entidad;
import colliders.DefaultCollider;

public abstract class Buff extends Entidad {
	public static final int ancho=80;
	public static final int alto=80;
	protected int timeLeft;
	
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
	
	public void updateBuff(Mapa m) {
		timeLeft--;
		if (timeLeft<=0) {
			terminarBuff(m);
		}
	}
	
	public abstract void terminarBuff(Mapa m);
	
}
