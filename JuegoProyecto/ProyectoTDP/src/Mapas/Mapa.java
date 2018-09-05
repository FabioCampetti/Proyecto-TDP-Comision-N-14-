package Mapas;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.LinkedList;
import java.util.Random;

import javax.swing.JLabel;
import javax.swing.JPanel;

import Naves.*;

public abstract class Mapa extends JPanel{
	protected LinkedList<Entidad> entidades;
	protected Jugador jug;
	
	protected Mapa() {
		super();
		this.setSize(720,1080);
		jug= new Jugador();
		this.setLayout(new GridLayout(6,6));
		this.add(jug.getPosicion());
		this.setVisible(true);
		this.setBackground(new Color(0,125,255));
	}
	public void movePlayer(int dir) {
		jug.mover(dir);
	}
}
