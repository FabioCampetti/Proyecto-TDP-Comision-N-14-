package Disparos;

import javax.swing.ImageIcon;

import Mapas.Mapa;
import Naves.Entidad;
import colliders.DefaultCollider;
import colliders.DisparoCollider;

public class DisparoEnemigo extends Disparo{
	private ImageIcon imagenDisparo = new ImageIcon(this.getClass().getResource("/Disparos/imagenDisparoEnemigo.png"));
	
	public DisparoEnemigo(int x,int y) {
		super();
		this.pos.setIcon(imagenDisparo);
		velocidad = 30;
		daño = 15;
		myCollider=new DisparoCollider();
	}
	public void mover(int x) {
		pos.setLocation(pos.getX(),pos.getY() + velocidad);
		if (pos.getY()>Mapa.ANCHO)
			this.morir();
	}
	
	public void colision(Entidad e) {
		e.aceptar(myCollider);
	}
	public void aceptar(DefaultCollider c) {
		c.collideDisparoEnemigo(this);
	}
	
}


