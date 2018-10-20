package Disparos;

import javax.swing.ImageIcon;

import Mapas.Mapa;
import Naves.Entidad;
import colliders.DefaultCollider;
import colliders.DisparoEnemigoCollider;

public class DisparoEnemigo extends Disparo{
	private ImageIcon imagenDisparo = new ImageIcon(this.getClass().getResource("/Disparos/disparoEnemigoPrototipo.png"));
	public static final int ancho = 50;
	public static final int alto = 75;
	
	public DisparoEnemigo(int x,int y) {
		super();
		this.pos.setBounds(x,y,ancho,alto);
		this.pos.setIcon(imagenDisparo);
		velocidad = 10;
		daño = 15;
		myCollider=new DisparoEnemigoCollider(daño);
	}
	public void mover(int x) {
		pos.setLocation(pos.getX(), pos.getY() + velocidad);
		if (pos.getY() > Mapa.ALTO)
			this.morir();
	}
	
	public void colision(Entidad e) {
		e.aceptar(myCollider);
	}
	public void aceptar(DefaultCollider c) {
		c.collideDisparoEnemigo(this);
	}
	
}


