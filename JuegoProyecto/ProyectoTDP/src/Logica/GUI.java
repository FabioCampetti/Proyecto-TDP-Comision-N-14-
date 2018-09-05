package Logica;
import Mapas.*;

import java.awt.Color;

import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class GUI extends JPanel {
	protected static Mapa mapa;
	
	/**
	 * Inicializacion de GUI con listeners para las flechitas.
	 * @param mapa JPanel que almacenara jugadores,enemigos, obstaculos,etc.
	 * 
	 */
	public GUI(Mapa mapa) {
		this.mapa = mapa;
		addKeyListener (new KeyListener() {
			public void keyTyped(KeyEvent e) {
				
			}
			public void keyReleased(KeyEvent e) {
			//
			}
			public void keyPressed(KeyEvent e) {
				final int aux = e.KEY_TYPED;
				mapa.movePlayer(aux);
			}
		});
		setFocusable(true);
	}
	/**
	 * Inicializacion del juego en si. Se crea frame principal y se le pega el JPanel del mapa.
	 */
	public static void main(String[] args) {
		JFrame frame = new JFrame("GameTest");
		frame.setSize(800,600);
		frame.setVisible(true);
		frame.add(mapa);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
