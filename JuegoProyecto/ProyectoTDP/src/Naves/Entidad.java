package Naves;
import Disparos.*;


public abstract class Entidad {

	protected int vida;
	protected Disparo disparo;
	protected Casilla pos;
	
	public Entidad(int vida,Casilla pos) {
		this.vida = vida;
		this.pos = pos;
	}
	public void mover(int dir) {
		Casilla casilla_movimiento = pos.getNearby(dir)
		
		if(casilla_movimiento != null) {
			this.pos = casilla_movimiento;
			//mover objeto dentro del mapa.
		}
		
	}
	public int getVida() {
		return vida;
	}
	public void setVida(int vida) {
		this.vida = vida;
	}
	public boolean isDead() {
		return (vida<=0);
	}
}
