package Naves;
import javax.swing.JLabel;

import Disparos.*;


public abstract class Entidad {

	protected int vida;
	protected Disparo disparo;
	protected JLabel pos;
	
	public Entidad() {
		vida=100;
	}
	public void mover(int x) {
		}
		
	
	public int getVida() {
		return vida;
	}
	public void setVida(int vida) {
		this.vida = vida;
	}
	public boolean isDead() {
		return (vida <= 0);
	}
	
	public JLabel getPosicion() {
		return pos;
	}
		
}
