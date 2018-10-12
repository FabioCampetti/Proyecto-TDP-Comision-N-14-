package Disparos;

import javax.swing.ImageIcon;
import Naves.Entidad;
import colliders.DefaultCollider;
import colliders.DisparoCollider;

public class DisparoJugador extends Disparo {
	private ImageIcon imagenDisparo = new ImageIcon(this.getClass().getResource("/Disparos/imagenDisparo.png"));
	/**
	 * DISPARO IMPLEMENTADO CON POCOS DETALLES - ICONO DE BOLA AZUL.
	 * PROBLEMA: EL DISPARO QUEDA ABAJO DEL FONDO DEL MAPA - PREGUNTAR
	 */
	
	public DisparoJugador(int x,int y) {
		super(x,y);
		this.pos.setIcon(imagenDisparo);
		velocidad = 30;
		daño = 35;
		myCollider=new DisparoCollider(this);
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
