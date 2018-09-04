package Naves;
import java.awt.event.KeyEvent;
import Disparos.*;


public class Jugador extends Entidad{
		
		public static final int left = KeyEvent.KEY_LOCATION_LEFT;
		public static final int right = KeyEvent.KEY_LOCATION_RIGHT;
	
		public Jugador(int vida,Casilla pos) {
			super(vida,pos);
			super.disparo = new DisparoJugador();
		}
		public void mover(int dir) {
			switch(dir) {
			case left : // izquierda
					super.mover(left);
					break;
			case right : // derecha
					super.mover(right);
					break;
			}
		}
		
}
