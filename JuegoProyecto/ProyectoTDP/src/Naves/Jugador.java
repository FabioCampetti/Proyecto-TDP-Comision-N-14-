package Naves;

import java.awt.event.KeyEvent;
import java.util.Collection;
import java.util.LinkedList;

import javax.swing.ImageIcon;
import Disparos.*;
import Escudos.Escudo;
import Escudos.EscudoEstandar;
import Mapas.Mapa;
import buffs.BuffTimer;
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
	private Collection<BuffTimer> buffsActivos;
	private Escudo escudoJugador;
	
	private ImageIcon frontIcon = new ImageIcon(this.getClass().getResource("/Naves/NaveJugadorFront.gif"));
	private ImageIcon leftIcon = new ImageIcon(this.getClass().getResource("/Naves/NaveJugadorLeft.gif"));
	private ImageIcon rightIcon = new ImageIcon(this.getClass().getResource("/Naves/NaveJugadorRight.gif"));
	
	public Jugador() {
		super();
		velocidad=20;
		pos.setBounds(720,900,ancho,alto);
		pos.setVisible(true);
		pos.setIcon(frontIcon);
		buffsActivos = new LinkedList<BuffTimer>();
		armaJugador= new ArmaJugadorEstandar(this);
		daño=50;
		escudoJugador = new EscudoEstandar();
		myCollider = new JugadorCollider(daño); 
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
	
	public void updateBuffs(Mapa m) {
		Collection<BuffTimer> buffsTerminados = new LinkedList<BuffTimer>();
		for (BuffTimer b: buffsActivos) {
			b.updateBuff(m);
			if (b.terminoBuff())
				buffsTerminados.add(b);
		}
		
		for (BuffTimer b: buffsTerminados) {
			buffsActivos.remove(b);
		}
	}
	
	public Collection<Disparo> disparar() {
		return armaJugador.disparar();
	}
	
	public void morir() {
		vida=0;
	}
	
	public void recibirDaño(int daño) {
		int dañoFinal;
		dañoFinal = escudoJugador.recibirDaño(daño);
		vida-=dañoFinal;
	}

	public void colision(Entidad e) {
		e.aceptar(myCollider);
	}
	
	public void cambiarArma(Arma a) {
		armaJugador=a;
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
		escudoJugador=e;
	}
}
