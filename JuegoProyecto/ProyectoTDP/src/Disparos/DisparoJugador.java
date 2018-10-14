package Disparos;

import javax.swing.ImageIcon;
import Naves.Entidad;
import colliders.DefaultCollider;
import colliders.DisparoCollider;

public class DisparoJugador extends Disparo {
	public static final int ancho=47;
	public static final int alto=88;
	
	private ImageIcon imagenDisparo = new ImageIcon(this.getClass().getResource("/Disparos/imagenDisparoJugador.png"));

	
	public DisparoJugador(int x,int y) {
		super();
		this.pos.setBounds(x,y,ancho,alto);
		this.pos.setIcon(imagenDisparo);
		velocidad = 30;
		daño = 35;
		myCollider = new DisparoCollider();
	}
	public void mover(int x) {
		pos.setLocation(pos.getX(),pos.getY() - velocidad);
		if (pos.getY()<0)
			this.morir();
	}
	public void colision(Entidad e) {
		e.aceptar(myCollider);
	}
	public void aceptar(DefaultCollider c) {
		c.collideDisparoJugador(this);
	}
}
