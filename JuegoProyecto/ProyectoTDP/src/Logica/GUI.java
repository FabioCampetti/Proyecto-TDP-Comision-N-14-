package Logica;
import Mapas.*;

import java.awt.Color;
import java.awt.Container;
import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class GUI extends JFrame {
	protected Mapa mapa;
	
	/**
	 * Inicializacion de GUI con listeners para las flechitas.
	 * @param mapa JPanel que almacenara jugadores,enemigos, obstaculos,etc.
	 * 
	 */
	/**
	 * Inicializacion del juego en si. Se crea frame principal y se le pega el JPanel del mapa.
	 */
	public GUI() {
		
		mapa = new Mapa1();
		this.add(mapa);

		this.addKeyListener(new KeyListener() {
			public void keyPressed(KeyEvent e) {
				
				final int aux = e.getKeyCode();
				mapa.movePlayer(aux);
			}
			public void keyReleased(KeyEvent e) { }
			public void keyTyped(KeyEvent e) { }
		});
		this.setSize(720,1080);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		
		
		
		
		
		
	}
	/*
		mapa = new Mapa1();
		GUI aux = new GUI();
		JFrame frame = new JFrame("GameTest");
		frame.setSize(800,600);
		frame.setVisible(true);
		frame.getContentPane().add(mapa);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	*/
	
	/**
	 * Lanza la interfaz gráfica
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI frame = new GUI();
					frame.setTitle("TEST");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
}
