package gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Mapas.Mapa;

public class GUI extends JFrame {
	protected Mapa mapa;
	private ContadorTiempo cont;
	private ImageIcon fondoMenu = new ImageIcon(this.getClass().getResource("/gui/fondoMenu.jpg"));

	/**
	 * Inicializacion de GUI con listeners para las flechitas.
	 * 
	 * @param mapa
	 *            JPanel que almacenara jugadores,enemigos, obstaculos,etc. /**
	 *            Inicializacion del juego en si. Se crea frame principal y se le
	 *            pega el JPanel del mapa.
	 */
	public GUI() {

		this.setTitle("Space Game");
		this.setSize(1920, 1080);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);

		mapa = new Mapa();
		this.add(mapa);

		this.addKeyListener(new KeyListener() {
			public void keyPressed(KeyEvent e) {
				int aux = e.getKeyCode();
				if (aux == KeyEvent.VK_SPACE) {
					if (!cont.isPaused())
						mapa.disparoPlayer();
				} else if (aux == KeyEvent.VK_R) {
					if (!cont.isPaused())
						mapa.recargar();
				} else if (aux == KeyEvent.VK_P) {
					cont.pause();
				} else {
					if (!cont.isPaused())
						mapa.movePlayer(aux);
				}
			}

			public void keyReleased(KeyEvent e) {
				mapa.setDefaultPlayerIcon();
			}

			public void keyTyped(KeyEvent e) {
			}
		});

		this.setSize(1920, 1080);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setFocusable(true);
		cont = new ContadorTiempo(mapa, this);
		cont.start();
	}

	public void menuPerder(int score) {
		/** Cierro GUI que se estaba ejecutando anteriormente. */
		this.setVisible(false);
		this.setFocusable(false);
		this.setEnabled(false);

		/** Inicialización de los botones. */
		JFrame frameAux = new JFrame();
		frameAux.setSize(500, 500);
		JLabel displayPerdiste = new JLabel();
		displayPerdiste.setText("<html>¡Perdiste!<br>Puntuación: " + score + "</html>");
		displayPerdiste.setForeground(Color.BLACK);

		JButton botonComienzo = new JButton("Jugar");
		JButton salir = new JButton("Salir");
		/** Inicialización del fondo del menú. */
		JLabel fondo = new JLabel();
		fondo.setIcon(fondoMenu);

		/** Creacion del panel y se le agrega el fondo */
		JPanel panel = new JPanel();

		/** Agregación de todos los botones al panel. */
		panel.setComponentZOrder(fondo, 0);
		panel.add(botonComienzo);
		panel.setComponentZOrder(botonComienzo, 0);
		panel.add(salir);
		panel.setComponentZOrder(salir, 0);
		panel.add(displayPerdiste);
		panel.setComponentZOrder(displayPerdiste, 0);

		frameAux.add(panel);
		frameAux.setVisible(true);

		/**
		 * Listener del boton comienzo.
		 */
		botonComienzo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frameAux.remove(panel);
				frameAux.remove(botonComienzo);
				frameAux.setVisible(false);
				frameAux.setFocusable(false);
				frameAux.setEnabled(false);
				GUI frame = new GUI();
				frame.setVisible(true);
				frame.setFocusable(true);
				frame.setEnabled(true);
			}
		});

		/**
		 * Listener del boton salir. Cierra el juego/menú.
		 */
		salir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frameAux.dispatchEvent(new WindowEvent(frameAux, WindowEvent.WINDOW_CLOSING));
			}
		});

	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrame frameAux = new JFrame();
					frameAux.setSize(500, 500);

					ImageIcon fondoMenu = new ImageIcon(this.getClass().getResource("/gui/fondoMenu.jpg"));

					/** Inicialización de los botones. */
					JButton botonComienzo = new JButton("Jugar");
					JButton instrucciones = new JButton("Cómo jugar");
					JButton salir = new JButton("Salir");

					/** Inicialización del fondo del menú. */
					JLabel fondo = new JLabel();
					fondo.setIcon(fondoMenu);

					/** Creacion del panel y se le agrega el fondo */
					JPanel panel = new JPanel();
					panel.add(fondo);

					/** Agregación de todos los botones al panel. */
					panel.setComponentZOrder(fondo, 0);
					panel.add(botonComienzo);
					panel.setComponentZOrder(botonComienzo, 0);
					panel.add(instrucciones);
					panel.setComponentZOrder(instrucciones, 0);
					panel.add(salir);
					panel.setComponentZOrder(salir, 0);

					frameAux.add(panel);
					frameAux.setVisible(true);

					botonComienzo.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							frameAux.remove(panel);
							frameAux.remove(botonComienzo);
							frameAux.setVisible(false);
							frameAux.setFocusable(false);
							frameAux.setEnabled(false);
							GUI frame = new GUI();
							frame.setVisible(true);
							frame.setFocusable(true);
							frame.setEnabled(true);
						}
					});

					salir.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							frameAux.dispatchEvent(new WindowEvent(frameAux, WindowEvent.WINDOW_CLOSING));
						}
					});

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}