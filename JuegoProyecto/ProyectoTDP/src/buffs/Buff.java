package buffs;

import colliders.DefaultCollider;
import mapas.Mapa;
import naves.Entidad;

public abstract class Buff extends Entidad {
	public final int ancho=80;
	public final int alto=80;
	
	@Override
	public void mover() {
		pos.setLocation(pos.getX(),pos.getY()+velocidad);
		if (pos.getY()>Mapa.ALTO)
			this.morir();
	}
	@Override
	public void colision(Entidad e) {
		e.aceptar(myCollider);
	}
	
	@Override
	public void aceptar(DefaultCollider c) {
		c.collideBuff(this);
	}
	
	public void congelar() {}	
	public void descongelar() {}ç
}
