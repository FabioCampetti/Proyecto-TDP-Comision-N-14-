package Naves;

import javax.swing.ImageIcon;

import Disparos.DisparoEnemigo;
import colliders.DefaultCollider;
import colliders.EnemigoCollider;
import inteligencias.IEnemigoBasico;

public class EnemigoArmado extends Enemigo {
	
	private static final int ancho = 132;
	private static final int alto= 135;
	private ImageIcon foto = new ImageIcon(this.getClass().getResource("/Naves/EnemigoArmado (1).gif"));
	
	public EnemigoArmado() {
		super();
		velocidad=20;
		pos.setBounds(50,50,ancho,alto);
		pos.setVisible(true);
		pos.setIcon(foto);
		IA=new IEnemigoBasico(velocidad);
		score = 75;
		myCollider = new EnemigoCollider();	
	}
	
	public void mover(int x) {
		IA.mover(pos);
	}
	
	public void colision(Entidad e) {
		e.aceptar(myCollider);
	}
	
	public void aceptar(DefaultCollider c) {
		c.collideEnemigo(this);
	}
	public int getScore() {
		return score;
	}
	
	public DisparoEnemigo disparar() {
		int val=(int) (ancho*0.5);
		DisparoEnemigo disparo = new DisparoEnemigo(this.pos.getX()+val,this.pos.getY()+200);
		return disparo;
	}
}
