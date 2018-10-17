package Naves;
import javax.swing.JLabel;

import Disparos.*;
import colliders.DefaultCollider;


public abstract class Entidad {
	
	protected int vida, velocidad,da�o;
	protected Disparo disparo;
	protected JLabel pos;
	protected DefaultCollider myCollider;
	
	public Entidad() {
		pos = new JLabel();
		vida=100;
		velocidad=0;
	}
	
	public abstract void mover(int x);
	
	public int getVida() {
		return vida;
	}
	
	public void setVida(int vida) {
		this.vida = vida;
		if(this.vida > 100)
			this.vida = 100;
	}
	
	public void setDa�o(int da�o) {
		this.da�o=da�o;
	}
	
	public boolean isDead() {
		return (vida<=0);
	}
	
	public void recibirDa�o(int da�o) {
		vida-=da�o;
	}
	
	public JLabel getPosicion() {
		return pos;
	}
	/**
	 * Caso para el jugador / obsctaculos.
	 */
	public  int getScore() {
		return 0;
	}
	
	public abstract void colision(Entidad e) ;
	
	public abstract void aceptar(DefaultCollider c);
	
	/**
	 * Este metodo generaliza la idea de "desaparecer" del mapa.
	 */
	public void morir() {
		vida = 0;
	}
	
	public int getda�o() {
		return da�o;
	}
}
