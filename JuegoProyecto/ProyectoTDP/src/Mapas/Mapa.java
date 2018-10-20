package Mapas;

import java.util.Collection;
import java.awt.Color;
import java.util.LinkedList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import Disparos.*;
import Naves.*;
import buffs.Buff;
import gui.Puntaje;
import obstaculos.Obstaculo;

public class Mapa extends JLayeredPane {
	private List<Entidad> entidades;
	private List<Disparo> disparos;
	private Jugador jug;
	public static final int ANCHO = 1920;
	public static final int ALTO = 1080;
	private ImageIcon background = new ImageIcon(this.getClass().getResource("/Mapas/fondo.jpg"));
	private enemiesFactory factory;
	private Puntaje score;

	public Mapa() {
		super();

		/** Creacion del jugador, puntaje, factory/enemigos. */
		creacionEntidades();
		addPlayerPuntaje();

		/** Seteo tamaño, imagen y layout del mapa. */
		creacionMapa();

		/** Inicializacion del nivel */
		this.startLevel();

	}

	private void creacionMapa() {
		JLabel fondoAux = new JLabel();
		this.setSize(ANCHO, ALTO);
		this.setLayout(null);
		this.setVisible(true);
		fondoAux.setBounds(0, 0, ANCHO, ALTO);
		fondoAux.setIcon(background);
		this.add(fondoAux, 0);
		this.moveToBack(fondoAux);
	}

	private void creacionEntidades() {
		entidades = new LinkedList<Entidad>();
		disparos = new LinkedList<Disparo>();
		jug = new Jugador();
		factory = new factoryLevelOne(jug.getPosicion());
		score = new Puntaje(jug.getVida());
	}

	private void addPlayerPuntaje() {
		this.add(jug.getPosicion(), 0);
		this.add(score.getLabelScore(), 0);
		this.add(score.getBarraVida(), 0);
		this.add(score.getLabelMaximo(), 0);
		
		this.add(score.getLabelDisparos(),0);

	}

	private void startLevel() {
		int xInicial = 100;
		int yInicial = (ALTO / 2) + 100;
		while (!factory.noObstacles()) {
			Obstaculo o = factory.createObstacle();
			entidades.add(o);
			o.getPosicion().setLocation(xInicial, yInicial);
			this.add(o.getPosicion(), 0);

			xInicial += 360;
		}
		xInicial = 40;
		yInicial = 40;
		while (!factory.noEnemies()) {
			Enemigo e = factory.createEnemy();
			entidades.add(e);
			e.getPosicion().setLocation(xInicial, yInicial);
			this.add(e.getPosicion(), 0);

			xInicial += 150;
			if (xInicial > ANCHO - 100) {
				xInicial = 40;
				yInicial += 200;
			}
			if (yInicial > ALTO) {
				yInicial = 40;
				xInicial = 50;
			}
		}
	}

	private void nextLevel() {
		if (factory.getNextFactory() != null) {
			factory = factory.getNextFactory();
			this.startLevel();
		} else
			this.ganarGame();
	}

	public void movePlayer(int dir) {
		jug.mover(dir);
	}

	public void setDefaultPlayerIcon() {
		jug.defaultIcon();
	}

	public void moveEntidades() {
		for (Entidad e : entidades) {
			e.mover(0);
		}
	}

	public void dispararEntidades() {
		for (Entidad e : entidades) {
			Collection<Disparo> disp = e.disparar();
			for (Disparo a : disp) {
				disparos.add(a);
				this.add(a.getPosicion(),0);
			}
		}
	}

	public void disparoPlayer() {
		if (!jug.isDead()) {
			Collection<Disparo> aux = jug.disparar();
			this.updateRestantes(jug.disparosRestantes());
			for (Disparo a : aux) {
				disparos.add(a);
				this.add(a.getPosicion(), 0);
			}
		}
	}

	private void updateScore(Entidad e) {
		score.actualizarPuntaje(e.getScore());
	}
	
	private void updateRestantes(int restantes) {
		score.actualizarRestantes(restantes);
	}
	
	public void updateVida(int v) {
		score.actualizarVida(v);
	}

	public void checkDisparos() {
		for (Disparo d : disparos)
			entidades.add(d);
		disparos.clear();
	}

	public boolean checkCollisions() {
		boolean murioJugador = false;

		if (entidades.isEmpty()) {
			this.nextLevel();
		}
		List<Entidad> listaMuertos = new LinkedList<Entidad>();
		List<Entidad> listaBuffs = new LinkedList<Entidad>();
		for (Entidad e1 : entidades) {
			for (Entidad e2 : entidades) {
				if (e1.getPosicion().getBounds().intersects(e2.getPosicion().getBounds()))
					e1.colision(e2);
			}
			if (e1.getPosicion().getBounds().intersects(jug.getPosicion().getBounds())) {
				jug.colision(e1);
				e1.colision(jug);

			}
			if (e1.isDead()) {
				listaMuertos.add(e1);
				Buff b = e1.lanzaBuff();
				if (b!=null)
					listaBuffs.add(b);
			}
		}

		for (Entidad e1 : listaMuertos) {
			entidades.remove(e1);
			this.remove(e1.getPosicion());
			updateScore(e1);
		}

		for (Entidad e1 : listaBuffs) {
			entidades.add(e1);
			this.add(e1.getPosicion());
			this.moveToFront(e1.getPosicion());
		}

		if (jug.isDead()) {
			this.remove(jug.getPosicion());
			murioJugador = true;
			score.checkUpdate();
		}
		this.repaint();
		return murioJugador;
	}

	public void updateBuffs() {
		jug.updateBuffs(this);
	}


	public void ganarGame() {
		JLabel textDisplay = new JLabel();

		textDisplay.setBounds(ANCHO / 2, ALTO / 2, 150, 50);
		textDisplay.setText("<html>¡Felicitaciones, ganaste!<br>Puntuación: " + score.getPuntaje() + "</html>");
		textDisplay.setForeground(Color.WHITE);
		textDisplay.setVerticalTextPosition(JLabel.BOTTOM);
		textDisplay.setHorizontalTextPosition(JLabel.CENTER);
		this.add(textDisplay, 0);

		score.checkUpdate();
	}

	public int getScore() {
		return score.getPuntaje();
	}

	public void recargar() {
		jug.recargar();
		this.updateRestantes(jug.disparosRestantes());
	}
	public Jugador getJugador() {
		return jug;
	}
	
	public void congelar() {
		for (Entidad e : entidades) {
			e.congelar();
		}
	}
	
	public void descongelar() {
		for (Entidad e : entidades) {
			e.descongelar();
		}
	}
}
