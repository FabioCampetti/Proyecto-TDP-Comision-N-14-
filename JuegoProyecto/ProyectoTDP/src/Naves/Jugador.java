package Naves;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import javax.swing.JLabel;
import Disparos.*;


public class Jugador extends Entidad{
		
		public static final int left = KeyEvent.KEY_LOCATION_LEFT;
		public static final int right = KeyEvent.KEY_LOCATION_RIGHT;
	
		public Jugador() {
			super();
			pos.setLocation(400, 500);
			disparo = new DisparoJugador();
		}
		public void mover(int x) {
			if(x==left)
				pos.setLocation(pos.getX()-10, pos.getY());
			else 
				if (x==right)
					pos.setLocation(pos.getX()+10, pos.getY());
		}
		
}
