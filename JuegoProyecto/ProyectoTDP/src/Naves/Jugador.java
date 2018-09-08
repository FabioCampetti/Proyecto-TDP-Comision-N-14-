package Naves;

import java.awt.event.KeyEvent;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.ImageIcon;
import Disparos.*;
import Mapas.Mapa;

public class Jugador extends Entidad {

	private static final int left = KeyEvent.VK_LEFT;
	private static final int right = KeyEvent.VK_RIGHT;

	public Jugador() {
		super();
		pos.setBounds(720,700,350,350);
		pos.setVisible(true);

		ImageIcon imagen = new ImageIcon();
		try {
			URL direccion = new URL("file:///C:/Users/Sandra/Documents/Proyecto-TDP-Comision-N-14-/JuegoProyecto/ProyectoTDP/src/Naves/aux10.gif");
			imagen = new ImageIcon(direccion);
		}
		catch(MalformedURLException p ) {
		}
		pos.setIcon(imagen);
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
	}
	/**
	 * TODO
	 */
	public void recibirDaño(int daño) {
	}
	
}
