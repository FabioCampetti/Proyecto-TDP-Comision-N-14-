package Mapas;

import java.awt.Color;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import Disparos.*;
import Naves.*;

public class Mapa extends JPanel {
	private LinkedList<Enemigo> enemigos;
	private Jugador jug;
	private JLabel fondo;
	public static final int ANCHO = 1920;
	public static final int LARGO = 1080;
	private ImageIcon background = new ImageIcon(this.getClass().getResource("/Mapas/fondo.jpg"));
	private enemiesFactory factory;
	private JLabel scoreLabel = new JLabel();
	private int score = 0;
	
	
	public Mapa() {
		super();
		this.setSize(ANCHO,LARGO);
		jug = new Jugador();
		this.setLayout(null);
		this.add(jug.getPosicion());
		
		scoreLabel.setBounds(25,25,150,50);
		scoreLabel.setText("Puntuacion: 0");
		scoreLabel.setForeground(Color.WHITE);
		this.add(scoreLabel);
		enemigos = new LinkedList<Enemigo>();
		this.setVisible(true);

		factory = new factoryLevelOne();
		this.startLevel();
		
		JLabel fondoAux = new JLabel();
		fondoAux.setBounds(0, 0,ANCHO,LARGO);
		fondoAux.setIcon(background);
		this.add(fondoAux);
		this.setComponentZOrder(scoreLabel,15);
		this.setComponentZOrder(jug.getPosicion(),3);
		this.setComponentZOrder(fondoAux,30);
		
	}
	private void startLevel() {
		int xInicial = 40;
		int yInicial = 40;
		while(!factory.isEmpty()) {
			Enemigo e = factory.createEnemy();
			enemigos.add(e);
			e.getPosicion().setLocation(xInicial,yInicial);
			this.add(e.getPosicion());
			this.setComponentZOrder(e.getPosicion(),2);
			xInicial+=100;
			if(xInicial > ANCHO - 100) {
				xInicial = 40;
				yInicial+= 350;
			}
			if(yInicial > LARGO) {
				yInicial = 40;
				xInicial = 50;
			}
			//yInicial+=15;
		}
	}
	private void nextLevel() {
		factory = factory.getNextFactory();
		if (factory!=null)
			this.startLevel();
	}
	/*
	private boolean levelOver() {
	}
	*/
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
		 Disparo aux = jug.disparar();
		// Cuando metemos el disparo en el mapa, la imagen del disparo queda abajo del
		// fondo del mapa.
		this.add(aux.getPosicion());
		aux.mover(0);
	}

	public void killEnemigos() {
		if(enemigos.isEmpty()) {
			this.nextLevel();
		}
		else {
			Enemigo e1 = enemigos.getFirst();
			e1.setVida(0);
			try {
			for (Enemigo e : enemigos) {
				if (e.isDead()) {
					e.morir();
					this.remove(e.getPosicion());
					enemigos.remove(e);
					this.updateScore(e);
				}
				}
			}
			catch (java.util.ConcurrentModificationException e) {}
		}
	}
	private void updateScore(Enemigo e) {
		score+=e.getScore();
		scoreLabel.setText("Puntuacion: "+score);
	}

}
