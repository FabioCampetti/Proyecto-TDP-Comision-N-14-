package naves;

import java.util.Random;

import buffs.Buff;
import inteligencias.Inteligencia;

/**
 * Clase encargada de modelar a todos los tipos de enemigos del juego.	
 *
 */
public abstract class Enemigo extends Entidad{
	protected Inteligencia IA;
	protected int score;
	
	public Buff lanzaBuff() {
		Random r = new Random();
		Buff buffNuevo=null;
		int caeBuff = r.nextInt(50);
		if (caeBuff < 10) {
			buffNuevo = buffRandom(this.getPosicion());
		}
		return buffNuevo;
	}
	public boolean explota() {
		return true;
	}
}
