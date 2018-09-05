package Mapas;

import java.util.LinkedList;
import java.util.Random;
import javax.swing.JPanel;

public abstract class Mapa extends JPanel{
	protected LinkedList<Entidad> entidades;
	protected Jugador jug;
	
	protected Mapa() {
		super();
		this.setSize(800, 600);
		jug= new Jugador(400,500);
	}
}
