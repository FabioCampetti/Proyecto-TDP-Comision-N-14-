package Naves;

import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import Disparos.*;
import Mapas.Mapa;
import colliders.JugadorCollider;

public class Jugador extends Entidad {

	private static final int left = KeyEvent.VK_LEFT;
	private static final int right = KeyEvent.VK_RIGHT;
	private ImageIcon foto = new ImageIcon(this.getClass().getResource("/Naves/imagenJugador.gif"));
	
	public Jugador() {
		super();
		pos.setBounds(720,700,350,350);
		pos.setVisible(true);
		pos.setIcon(foto);
		coll = new JugadorCollider(); 
	}
	public void mover(int x) {
		if (x == left) {
			{if(pos.getX()> - 55)
			pos.setLocation(pos.getX() - 20, pos.getY());}
		}
		else 
			if (x == right)
				if(pos.getX()< Mapa.ANCHO - 250)
					pos.setLocation(pos.getX() + 20, pos.getY());
	}
	/**
	 * TODO
	 * Falta saber cómo hacerlo.
	 * EL DISPARO QUEDA DEBAJO DEL FONDO DEL MAPA CUANDO SE DISPARA.
	 */
	public Disparo disparar() {
		DisparoJugador disparo = new DisparoJugador(this.pos.getX(),this.pos.getY());
		return disparo;
	}
	/**
	 * TODO
	 * Redefinicion del metodo morir segun el jugador
	 * Meter explosion de la nave o un mensaje que diga "game over" aca.
	 */
	public void morir() {
		this.pos.setVisible(false);
		this.pos.setIcon(null);
	}
	/**
	 * TODO
	 */
	public void recibirDaño(int daño) {
	}
	
}
