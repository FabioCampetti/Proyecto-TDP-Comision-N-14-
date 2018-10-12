package Mapas;

import java.awt.Color;
import java.util.LinkedList;
import java.util.List;


import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import Disparos.*;
import Naves.*;
import obstaculos.Obstaculo;
import obstaculos.ObstaculoJugador;

public class Mapa extends JPanel {
	private List<Entidad> entidades;
	private List<Disparo> disparos;
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
		scoreLabel.setForeground(Color.BLACK);
		this.add(scoreLabel);
		entidades = new LinkedList<Entidad>();
		disparos= new LinkedList<Disparo>();
		this.setVisible(true);

		factory = new factoryLevelOne(jug.getPosicion());
		this.startLevel();
		
		//JLabel fondoAux = new JLabel();
		//fondoAux.setBounds(0, 0,ANCHO,LARGO);
		//fondoAux.setIcon(background);
		//this.add(fondoAux);
		this.setComponentZOrder(scoreLabel,15);
		this.setComponentZOrder(jug.getPosicion(),3);
		//this.setComponentZOrder(fondoAux,30);
		
	}
	private void startLevel() {
		int xInicial = 100;
		int yInicial = (LARGO/2)+100;	
		while (!factory.noObstacles()) {
			Obstaculo o = factory.createObstacle();
			entidades.add(o);
			o.getPosicion().setLocation(xInicial, yInicial);
			this.add(o.getPosicion());
			this.setComponentZOrder(o.getPosicion(),2);
			xInicial+=460;
		}
		 xInicial = 40;
		 yInicial = 40;
		while(!factory.noEnemies()) {
			Enemigo e = factory.createEnemy();
			entidades.add(e);
			e.getPosicion().setLocation(xInicial,yInicial);
			this.add(e.getPosicion());
			this.setComponentZOrder(e.getPosicion(),2);
			xInicial+=150;
			if(xInicial > ANCHO - 100) {
				xInicial = 40;
				yInicial+= 200;
			}
			if(yInicial > LARGO) {
				yInicial = 40;
				xInicial = 50;
			}
		}
	}
	private void nextLevel() {
		factory = factory.getNextFactory();
		if (factory!=null)
			this.startLevel();
	}
	
	public void movePlayer(int dir) {
		jug.mover(dir);
	}

	public void moveEntidades() {
		for (Entidad e : entidades) {
			e.mover(0);
		}
	}

	public void disparoPlayer() {
		if (!jug.isDead()) {
			Disparo aux = jug.disparar();
			disparos.add(aux);
			this.add(aux.getPosicion());
		}
	}
	
	private void updateScore(Entidad e) {
		score+=e.getScore();
		scoreLabel.setText("Puntuacion: "+score);
	}
	
	public void checkDisparos() {
		for (Disparo d: disparos)
			entidades.add(d);
		disparos.clear();
	}
	
	public boolean checkCollisions() {
		boolean murioJugador= false;
		
		if (entidades.isEmpty()) {
			this.nextLevel();
		}
		List<Entidad> listaMuertos=new LinkedList<Entidad>();
		for (Entidad e1: entidades) {
			for (Entidad e2: entidades) {
				if (e1.getPosicion().getBounds().intersects(e2.getPosicion().getBounds()))
					e1.colision(e2);
			}
			if (e1.getPosicion().getBounds().intersects(jug.getPosicion().getBounds()))
				jug.colision(e1);
			if (e1.isDead()) {
				listaMuertos.add(e1);
			}
		}
		
		for (Entidad e1: listaMuertos) {
			entidades.remove(e1);
			this.remove(e1.getPosicion());
			updateScore(e1);
		}
		
		if (jug.isDead()) {
			this.remove(jug.getPosicion());
			murioJugador=true;
		}
		this.repaint();
		return murioJugador;
	}
}
