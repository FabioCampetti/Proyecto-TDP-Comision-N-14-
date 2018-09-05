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
		
<<<<<<< HEAD
	}
=======
	
>>>>>>> 0aba0ea151bba359dfa704e8b8c5486da3f40fa0
	public int getVida() {
		return vida;
	}
	public void setVida(int vida) {
		this.vida = vida;
	}
	public boolean isDead() {
		return (vida<=0);
	}
<<<<<<< HEAD
=======
	
	public JLabel getPosicion() {
		return pos;
	}
		
>>>>>>> 0aba0ea151bba359dfa704e8b8c5486da3f40fa0
}
