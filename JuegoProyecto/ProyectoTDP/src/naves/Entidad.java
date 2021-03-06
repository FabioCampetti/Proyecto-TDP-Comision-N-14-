package naves;
import java.util.Collection;
import java.util.LinkedList;
import java.util.Random;

import javax.swing.JLabel;

import buffs.Buff;
import buffs.BuffArma;
import buffs.BuffCongelarPlayer;
import buffs.BuffCongelarTiempo;
import buffs.BuffEscudo;
import buffs.BuffSuperMisil;
import buffs.BuffVida;
import colliders.DefaultCollider;
import disparos.Disparo;


public abstract class Entidad {
	
	protected int vida, velocidad,da�o;
	protected Disparo disparo;
	protected JLabel pos;
	protected DefaultCollider myCollider;
	protected Memento<Integer> memVelocidad;
	
	public Entidad() {
		pos = new JLabel();
		vida=100;
		velocidad=0;
	}
	
	public abstract void mover();
	
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
	
	public  int getScore() {
		return 0;
	}
	
	public abstract void colision(Entidad e) ;
	
	public abstract void aceptar(DefaultCollider c);
	
	
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
	
	protected void guardarVelocidad(){
		memVelocidad = new Memento<Integer>(velocidad);
	}
	
	protected void devolverVelocidad() {
		if (memVelocidad!=null) {
			velocidad=memVelocidad.getState();
		}
	}
	
	public Buff lanzaBuff() {return null;}
	
	protected Buff buffRandom(JLabel pos) {
		int x, y;
		Random rand = new Random();
		int tipoBuff = rand.nextInt(60);
		x = pos.getX();
		y = pos.getY();
		
		Buff res = null;
		
		if (tipoBuff < 10)
			res = new BuffArma(x, y);
		else if (tipoBuff < 20) {
			res = new BuffVida(x, y);
		} else if (tipoBuff < 30) {
			res = new BuffEscudo(x, y);
		} else if (tipoBuff < 40) {
			res = new BuffCongelarTiempo(x,y);
		} else if (tipoBuff < 50) {
			res = new BuffSuperMisil(x,y);
		} else if (tipoBuff < 60) {
			res = new BuffCongelarPlayer(x,y);
		}
		return res;
	}
	
	public void congelar() {
		if(velocidad!=0) {
			guardarVelocidad();
			velocidad = 0;
		}
	}
	
	public void descongelar() {
		devolverVelocidad();
	}
	
	public boolean isFrozen() {
		return (velocidad == 0);
	}
	
	public boolean explota() {
		return false;
	}
}
