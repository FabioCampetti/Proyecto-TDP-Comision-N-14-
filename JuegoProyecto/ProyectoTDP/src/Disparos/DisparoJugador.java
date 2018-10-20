package Disparos;

import javax.swing.ImageIcon;
import Naves.Entidad;
import colliders.DefaultCollider;
import colliders.DisparoCollider;
import inteligencias.IDisparoEstandar;

public class DisparoJugador extends Disparo {
	public static final int ancho=47;
	public static final int alto=88;
	
	private ImageIcon imagenDisparo = new ImageIcon(this.getClass().getResource("/Disparos/imagenDisparoJugador.png"));
	
	public DisparoJugador(int x,int y) {
		super();
		this.pos.setBounds(x,y,ancho,alto);
		this.pos.setIcon(imagenDisparo);
		velocidad = 10;
		daño = 35;
		myCollider = new DisparoCollider(daño);
		myInteligencia = new IDisparoEstandar();
	}
	public void mover(int x) {
		myInteligencia.mover(this);
	}
	public void colision(Entidad e) {
		e.aceptar(myCollider);
	}
	public void aceptar(DefaultCollider c) {
		c.collideDisparoJugador(this);
	}
}
