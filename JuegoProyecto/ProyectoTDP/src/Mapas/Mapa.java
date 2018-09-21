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
		scoreLabel.setBounds(0,0,150,150);
		scoreLabel.setText("Puntuacion: 0");
		this.add(scoreLabel);
		enemigos = new LinkedList<Enemigo>();
		//Esto es para agregar un solo enemigo para testear, va a cambiar
		//enemigos.add(new Kamikaze());
		//this.add(enemigos.getFirst().getPosicion());
		this.setVisible(true);

		//FACTORY 
		factory = new factoryLevelOne();
		this.startLevel();
		
		JLabel fondoAux = new JLabel();
		fondoAux.setBounds(0, 0,ANCHO,LARGO);
		//fondoAux.setIcon(background);
		//this.add(fondoAux);
		
		//this.setComponentZOrder(fondoAux,30);

		
	}
	private void startLevel() {
		int xInicial = 40;
		int yInicial = 40;
		while(!factory.isEmpty()) {
			Enemigo e = factory.createEnemy();
			enemigos.add(e);
			e.getPosicion().setLocation(xInicial,yInicial);
			this.add(e.getPosicion());
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
			//Cuando inicializa nivel 2 los enemigos se meten abajo del label.
			this.nextLevel();
		}
		else {
			Enemigo e1 = enemigos.getFirst();
			e1.setVida(0);
			for (Enemigo e : enemigos) {
				if (e.isDead()) {
					e.morir();
					this.remove(e.getPosicion());
					enemigos.remove(e);
					this.updateScore(e);
				}
			}
		}
	}
	private void updateScore(Enemigo e) {
		score+=e.getScore();
		scoreLabel.setText("Puntuacion: "+score);
	}

}
