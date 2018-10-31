package mapas;

import java.awt.Color;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;

import buffs.Buff;
import disparos.Disparo;
import gui.Puntaje;
import naves.Enemigo;
import naves.Entidad;
import naves.Jugador;
import obstaculos.Obstaculo;

public class Mapa extends JLayeredPane {
	private List<Entidad> entidades;
	private List<Disparo> disparos;
	private List<Explosion> explosiones;
	private Jugador jug;
	public static final int ANCHO = 1920;
	public static final int ALTO = 1080;
	private ImageIcon background = new ImageIcon(this.getClass().getResource("/Mapas/Fondo2.jpg"));
	private EnemiesFactory factory;
	private Puntaje score;

	public Mapa() {
		super();

		/* Creacion del jugador, puntaje, factory/enemigos. */
		creacionEntidades();
		addPlayerPuntaje();

		/* Seteo tamaño, imagen y layout del mapa. */
		creacionMapa();

		/* Inicializacion del nivel */
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
		explosiones = new LinkedList<Explosion>();
		jug = Jugador.getInstance();
		factory = new FactoryLevelOne(jug.getPosicion());
		score = new Puntaje(jug.getVida());
	}

	private void addPlayerPuntaje() {
		this.add(jug.getPosicion(), 0);
		this.add(score.getLabelScore(), 0);
		this.add(score.getBarraVida(), 0);
		this.add(score.getLabelMaximo(), 0);
		this.add(score.getLabelDisparos(), 0);
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
		xInicial = 100;
		yInicial = 40;
		while (!factory.noEnemies()) {
			Enemigo e = factory.createEnemy();
			entidades.add(e);
			e.getPosicion().setLocation(xInicial, yInicial);
			this.add(e.getPosicion(), 0);

			xInicial += 150;
			if (xInicial > ANCHO - 200) {
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
		factory = factory.getNextFactory();
		if (factory != null) {
			this.startLevel();
		}
	}

	public boolean youWon() {
		return (factory == null);
	}

	public boolean youLost() {
		boolean murioJugador = false;
		if (jug.isDead()) {
			this.remove(jug.getPosicion());
			murioJugador = true;
		}
		return murioJugador;
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
				this.add(a.getPosicion(), 0);
			}
		}
	}

	public void disparoPlayer() {
		Collection<Disparo> aux = jug.disparar();
		this.updateRestantes(jug.disparosRestantes());
		for (Disparo a : aux) {
			disparos.add(a);
			this.add(a.getPosicion(), 0);
		}
	}

	private void updateScore(Entidad e) {
		score.actualizarPuntaje(e.getScore());
	}

	private void updateRestantes(int restantes) {
		score.actualizarRestantes(restantes);
	}

	public void updateVida() {
		score.actualizarVida(jug.getVida());
	}

	public void checkDisparos() {
		for (Disparo d : disparos)
			entidades.add(d);
		disparos.clear();
	}

	public void checkCollisions() {

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
				if (b != null)
					listaBuffs.add(b);
			}
		}

		for (Entidad e1 : listaMuertos) {
			entidades.remove(e1);
			this.remove(e1.getPosicion());
			updateScore(e1);
			if (e1.explota()) {
				/* Pone explosiones cuando mueren enemigos */
				Explosion e = new Explosion(e1.getPosicion().getX(), e1.getPosicion().getY());
				explosiones.add(e);
				this.add(e.getLabel(), 0);
			}
		}

		for (Entidad e1 : listaBuffs) {
			entidades.add(e1);
			this.add(e1.getPosicion());
			this.moveToFront(e1.getPosicion());
		}

		this.repaint();
	}

	public void checkExplosiones() {
		for (Explosion e : explosiones) {
			e.tick();
			if (e.isDone()) {
				this.remove(e.getLabel());
			}
		}
	}

	public void updateBuffs() {
		jug.updateBuffs(this);
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
