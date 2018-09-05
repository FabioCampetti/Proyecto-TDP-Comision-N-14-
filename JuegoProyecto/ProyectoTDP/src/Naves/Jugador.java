package Naves;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import Disparos.*;


public class Jugador extends Entidad{
		
		public static final int left = KeyEvent.KEY_LOCATION_LEFT;
		public static final int right = KeyEvent.KEY_LOCATION_RIGHT;
	
		public Jugador() {
			super();
			pos.setLocation(400, 500);
			disparo = new DisparoJugador();
			
			try {
				URL direccion=new URL("C:\\\\Users\\\\Maria Ester Sack\\\\Downloads\\\\pikachu-clipart-png-icon-13.png");
				ImageIcon image=new ImageIcon(direccion);
				pos.setIcon(image);
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		public void mover(int x) {
			if(x==left)
				pos.setLocation(pos.getX()-10, pos.getY());
			else 
				if (x==right)
					pos.setLocation(pos.getX()+10, pos.getY());
		}
		
}
