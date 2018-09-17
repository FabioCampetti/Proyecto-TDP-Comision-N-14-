package Mapas;


import java.net.MalformedURLException;
import java.net.URL;
import java.util.LinkedList;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import Disparos.*;
import Naves.*;

public abstract class Mapa extends JPanel{
	protected LinkedList<Enemigo> enemigos;
	protected Jugador jug;
	protected JLabel fondo;
	public static final int ANCHO = 1920;
	public static final int LARGO = 1080;
	private ImageIcon background = new ImageIcon(this.getClass().getResource("/Mapas/fondo.jpg"));
	protected Mapa() {
		super();
		this.setSize(1920,1080);
		jug= new Jugador();
		this.setLayout(null);
		this.add(jug.getPosicion());
		this.setVisible(true);
		
		JLabel fondoAux = new JLabel();
		fondoAux.setBounds(0,0,1920,1080);
		fondoAux.setIcon(background);
		this.add(fondoAux);
	}
	public void movePlayer(int dir) {
		jug.mover(dir);
	}
	/**
	 * VER ESTE METODO
	 */
	public void moveEnemigos() {
		for (Enemigo e : enemigos) {
			e.mover(0);
		}
	}
	/**
	 * DISPARO QUEDA ABAJO DEL FONDO DEL MAPA.
	 */
	public void killJugador() {
		jug.morir();
		this.remove(jug.getPosicion());
		jug = null;
	}
	public void disparoPlayer() {
		//Disparo aux = jug.disparar();
		//Cuando metemos el disparo en el mapa, la imagen del disparo queda abajo del fondo del mapa.
		//this.add(aux.getPosicion());	
		//aux.mover(0);
	}
	
}
