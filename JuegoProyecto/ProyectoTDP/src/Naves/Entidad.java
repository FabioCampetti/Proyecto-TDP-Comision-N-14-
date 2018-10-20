package Naves;
import java.util.Collection;
import java.util.LinkedList;
import java.util.Random;

import javax.swing.JLabel;

import Disparos.*;
import buffs.Buff;
import buffs.BuffArma;
import buffs.BuffEscudo;
import buffs.BuffVida;
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
	
	public int getVelocidad() {
		return velocidad;
	}
	
	public Collection<Disparo> disparar(){
		return new LinkedList<Disparo>();
	}
	
	public Buff lanzaBuff() {return null;}
	
	protected Buff buffRandom(JLabel pos) {
		int x, y;
		Buff res;
		Random rand = new Random();
		int tipoBuff = rand.nextInt(50);
		x = pos.getX();
		y = pos.getY();

		/* Esto se borra despues cuando tengamos los buffs */
		res = new BuffArma(x, y);

		// Se define que buff cae aleatoriamente
		if (tipoBuff < 10)
			res = new BuffArma(x, y);
		else if (tipoBuff < 20) {
			res = new BuffVida(x, y);
		} else if (tipoBuff < 30) {
			res = new BuffEscudo(x, y);
		} else if (tipoBuff < 40) {
		} else {
		}
		return res;
	}
}
