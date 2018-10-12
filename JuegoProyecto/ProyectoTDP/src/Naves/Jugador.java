package Naves;

import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import Disparos.*;
import Mapas.Mapa;
import colliders.DefaultCollider;
import colliders.JugadorCollider;

public class Jugador extends Entidad {

	private static final int left = KeyEvent.VK_LEFT;
	private static final int right = KeyEvent.VK_RIGHT;
	private static final int up = KeyEvent.VK_UP;
	private static final int down = KeyEvent.VK_DOWN;
	private static final int ancho = 190;
	private static final int largo= 150;
	
	
	private ImageIcon frontIcon = new ImageIcon(this.getClass().getResource("/Naves/NaveJugadorFront.gif"));
	private ImageIcon leftIcon = new ImageIcon(this.getClass().getResource("/Naves/NaveJugadorLeft.gif"));
	private ImageIcon rightIcon = new ImageIcon(this.getClass().getResource("/Naves/NaveJugadorRight.gif"));
	
	public Jugador() {
		super();
		velocidad=20;
		pos.setBounds(720,900,ancho,largo);
		pos.setVisible(true);
		pos.setIcon(frontIcon);
		myCollider = new JugadorCollider(); 
	}
	public void mover(int x) {
		if (x == left) {
			if(pos.getX()> 0)
				pos.setLocation(pos.getX() - velocidad, pos.getY());
			pos.setIcon(leftIcon);
		}
		else if (x == right) {
			if(pos.getX()< Mapa.ANCHO - ancho)
				pos.setLocation(pos.getX() + velocidad, pos.getY());
			pos.setIcon(rightIcon);
		}
		else if(x == up) {
			if (pos.getY()>0)
				pos.setLocation(pos.getX(), pos.getY() - velocidad);
		}
		else if(x == down) {
			if (pos.getY()< Mapa.LARGO - largo)
				pos.setLocation(pos.getX(), pos.getY() + velocidad);
		}
	}
	
	public Disparo disparar() {
		int val=(int) (ancho*0.5);
		DisparoJugador disparo = new DisparoJugador(this.pos.getX()+val,this.pos.getY());
		return disparo;
	}
	/**
	 * TODO
	 * Redefinicion del metodo morir segun el jugador
	 * Meter explosion de la nave o un mensaje que diga "game over" aca.
	 */
	public void morir() {
		vida=0;
	}
	/**
	 * TODO
	 */
	public void recibirDaño(int daño) {
		vida-=daño;
	}
	@Override
	public void colision(Entidad e) {
		e.aceptar(myCollider);
	}
	
	public void aceptar(DefaultCollider c) {
		c.collideJugador(this);
	}
	
	public void defaultIcon() {
		pos.setIcon(frontIcon);
	}
}
