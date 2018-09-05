package Mapas;

import java.util.LinkedList;
import java.util.Random;
import javax.swing.JPanel;

import Naves.*;

public abstract class Mapa extends JPanel{
	protected LinkedList<Entidad> entidades;
	protected Jugador jug;
	
	protected Mapa() {
		super();
		this.setSize(800, 600);
		jug= new Jugador();
		this.add(jug.getPosicion());
	}
	public void movePlayer(int dir) {
		jug.mover(dir);
	}
}
