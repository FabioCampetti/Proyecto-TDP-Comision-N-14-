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
		myCollider=new DisparoCollider(this);
	}
	/**
	 * ACOMODAR TODO - PREGUNTAR SOBRE TREAD PARA VER MOVIMIENTO MÁS REAL.
	 */
	public void mover(int x) {
		//pos.setLocation(pos.getX(),pos.getY() - 350);
		
		while(pos.getY() >	0) {
			pos.setLocation(pos.getX(),pos.getY() - 10);
		}
		
		
	}
	
	public void colision(Entidad e) {
		e.aceptar(myCollider);
	}
	
	public void aceptar(DefaultCollider c) {
		c.collideDisparoJugador(this);
	}
	
}
