package Naves;

import java.awt.event.KeyEvent;
import java.util.Collection;

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
	public static final int ancho = 190;
	public static final int alto= 150;
	private Arma armaJugador;
	
	private ImageIcon frontIcon = new ImageIcon(this.getClass().getResource("/Naves/NaveJugadorFront.gif"));
	private ImageIcon leftIcon = new ImageIcon(this.getClass().getResource("/Naves/NaveJugadorLeft.gif"));
	private ImageIcon rightIcon = new ImageIcon(this.getClass().getResource("/Naves/NaveJugadorRight.gif"));
	
	public Jugador() {
		super();
		velocidad=20;
		pos.setBounds(720,900,ancho,alto);
		pos.setVisible(true);
		pos.setIcon(frontIcon);
		armaJugador= new ArmaJugadorEstandar(this);
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
			if (pos.getY()< Mapa.ALTO - alto-35)
				pos.setLocation(pos.getX(), pos.getY() + velocidad);
		}
	}
	
	public Collection<Disparo> disparar() {
		return armaJugador.disparar();
	}
	
	public void morir() {
		vida=0;
	}
	
	public void recibirDaño(int daño) {
		vida-=daño;
	}

	public void colision(Entidad e) {
		e.aceptar(myCollider);
	}
	
	public void cambiarArma(Arma a) {
		armaJugador=a;
	}
	
	public void aceptar(DefaultCollider c) {
		c.collideJugador(this);
	}
	
	public void defaultIcon() {
		pos.setIcon(frontIcon);
	}
}
