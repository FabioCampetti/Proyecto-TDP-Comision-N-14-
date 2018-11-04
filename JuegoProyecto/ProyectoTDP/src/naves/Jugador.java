package naves;

import java.awt.event.KeyEvent;
import java.util.Collection;
import java.util.LinkedList;

import javax.swing.ImageIcon;

import buffs.BuffTimer;
import colliders.DefaultCollider;
import colliders.JugadorCollider;
import disparos.Arma;
import disparos.ArmaJugadorEstandar;
import disparos.Disparo;
import escudos.Escudo;
import escudos.EscudoEstandar;
import inteligencias.IJugador;
import mapas.Mapa;

public class Jugador extends Entidad {
	private static Jugador instancia = null;
	private static final int left = KeyEvent.VK_LEFT;
	private static final int right = KeyEvent.VK_RIGHT;
	public static final int ancho = 120;
	public static final int alto = 120;
	private Arma armaJugador;
	private Collection<BuffTimer> buffsActivos;
	private Escudo escudoJugador;
	private IJugador IA;

	private ImageIcon frontIcon = new ImageIcon(this.getClass().getResource("/Naves/NaveJugadorFront.gif"));
	private ImageIcon leftIcon = new ImageIcon(this.getClass().getResource("/Naves/NaveJugadorLeft.gif"));
	private ImageIcon rightIcon = new ImageIcon(this.getClass().getResource("/Naves/NaveJugadorRight.gif"));

	public static Jugador getInstance() {
		if (instancia == null)
			return new Jugador();
		return instancia;
	}

	private Jugador() {
		super();
		velocidad = 20;
		pos.setBounds(900, 960, ancho, alto);
		pos.setVisible(true);
		pos.setIcon(frontIcon);
		buffsActivos = new LinkedList<BuffTimer>();
		armaJugador = new ArmaJugadorEstandar(this);
		daño = 50;
		escudoJugador = new EscudoEstandar();
		myCollider = new JugadorCollider(daño);
		IA = new IJugador();
	}

	public void mover(int dir) {
		Integer dirFinal = new Integer(dir);
		IA.addMove(dirFinal);

		if (dir == left) {
			pos.setIcon(leftIcon);
		} else if (dir == right) {
			pos.setIcon(rightIcon);
		}
	}

	public void mover() {
		IA.mover(this);
	}

	public void updateBuffs(Mapa m) {
		Collection<BuffTimer> buffsTerminados = new LinkedList<BuffTimer>();
		for (BuffTimer b : buffsActivos) {
			b.updateBuff(m);
			if (b.terminoBuff())
				buffsTerminados.add(b);
		}

		for (BuffTimer b : buffsTerminados) {
			buffsActivos.remove(b);
		}
	}

	public Collection<Disparo> disparar() {
		Collection<Disparo> res = new LinkedList<Disparo>();
		if (!isDead()) {
			res = armaJugador.disparar();
		}
		return res;
	}

	public void morir() {
		vida = 0;
	}

	public void recibirDaño(int daño) {
		int dañoFinal;
		dañoFinal = escudoJugador.recibirDaño(daño);
		vida -= dañoFinal;
	}

	public void colision(Entidad e) {
		e.aceptar(myCollider);
	}

	public void cambiarArma(Arma a) {
		armaJugador = a;
	}

	public void addBuff(BuffTimer b) {
		buffsActivos.add(b);
	}

	public void aceptar(DefaultCollider c) {
		c.collideJugador(this);
	}

	public void defaultIcon() {
		pos.setIcon(frontIcon);
	}

	public void recargar() {
		armaJugador.recargar();
	}

	public void setEscudo(Escudo e) {
		escudoJugador = e;
	}

	public int disparosRestantes() {
		return armaJugador.disparosRestantes();
	}

	public void setImagenesDefault() {
		frontIcon = new ImageIcon(this.getClass().getResource("/Naves/NaveJugadorFront.gif"));
		leftIcon = new ImageIcon(this.getClass().getResource("/Naves/NaveJugadorLeft.gif"));
		rightIcon = new ImageIcon(this.getClass().getResource("/Naves/NaveJugadorRight.gif"));
		defaultIcon();
		pos.repaint();
	}

	public void setImagenesEscudo() {
		frontIcon = new ImageIcon(this.getClass().getResource("/Naves/NaveJugadorFrontEscudo.gif"));
		leftIcon = new ImageIcon(this.getClass().getResource("/Naves/NaveJugadorLeftEscudo.gif"));
		rightIcon = new ImageIcon(this.getClass().getResource("/Naves/NaveJugadorRightEscudo.gif"));
		defaultIcon();
		pos.repaint();
	}
}
