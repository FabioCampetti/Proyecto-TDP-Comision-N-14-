package gui;

import java.awt.Component;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import mapas.Mapa;

public class GUI extends JFrame {
	protected Mapa mapa;
	private ContadorTiempo cont;
	private ImageIcon imagenJugar = new ImageIcon(this.getClass().getResource("/gui/Jugar.png"));
	private ImageIcon imagenSalir = new ImageIcon(this.getClass().getResource("/gui/Salir.png"));
	private ImageIcon imagenComoJugar = new ImageIcon(this.getClass().getResource("/gui/ComoJugar.png"));
	private ImageIcon fondoMenu = new ImageIcon(this.getClass().getResource("/gui/FondoMenu.jpg"));
	private ImageIcon imagenPerdiste = new ImageIcon(this.getClass().getResource("/gui/GameOver.png"));
	private ImageIcon imagenGanaste = new ImageIcon(this.getClass().getResource("/gui/YouWon.png"));

	/**
	 * Inicializacion de GUI con listeners para las flechitas.
	 * 
	 * @param mapa
	 *            JPanel que almacenara jugadores,enemigos, obstaculos,etc. /**
	 *            Inicializacion del juego en si. Se crea frame principal y se le
	 *            pega el JPanel del mapa.
	 */

	public GUI() {
		this.setSize(1920, 1080);
		this.setUndecorated(true);
		this.setResizable(false);

		/* Inicialización de los label. */
		JLabel comienzo = new JLabel();
		comienzo.setVerticalAlignment(SwingConstants.TOP);
		comienzo.setHorizontalAlignment(SwingConstants.CENTER);
		comienzo.setBounds(872, 219, 175, 52);
		JLabel instrucciones = new JLabel();
		instrucciones.setAlignmentX(Component.CENTER_ALIGNMENT);
		instrucciones.setHorizontalAlignment(SwingConstants.CENTER);
		instrucciones.setBounds(784, 514, 352, 52);
		JLabel salir = new JLabel();
		salir.setBounds(882, 831, 157, 52);

		comienzo.setIcon(imagenJugar);
		salir.setIcon(imagenSalir);
		instrucciones.setIcon(imagenComoJugar);

		/* Inicialización del fondo del menú. */
		JLabel fondo = new JLabel();
		fondo.setLocation(0, 0);
		fondo.setSize(1920, 1080);
		fondo.setIcon(fondoMenu);

		/* Creacion del panel y se le agrega el fondo */
		Container panel = getContentPane();
		panel.setLayout(null);
		panel.add(comienzo);
		panel.setComponentZOrder(comienzo, 0);
		panel.add(instrucciones);
		panel.setComponentZOrder(instrucciones, 0);
		panel.add(salir);
		panel.setComponentZOrder(salir, 0);
		panel.add(fondo);

		this.setVisible(true);
		comienzo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				jugar();
			}

		});

		salir.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				System.exit(DISPOSE_ON_CLOSE);
			}
		});
	}

	public void jugar() {
		/* Limpio la GUI */
		getContentPane().removeAll();
		getContentPane().repaint();

		ImageIcon imagenCruz = new ImageIcon(this.getClass().getResource("/gui/CruzCerrar.png"));
		getContentPane().setLayout(null);
		JLabel labelCerrar = new JLabel("");

		labelCerrar.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				System.exit(DISPOSE_ON_CLOSE);
			}
		});

		labelCerrar.setBounds(1875, 39, imagenCruz.getIconWidth(), imagenCruz.getIconHeight());
		labelCerrar.setIcon(imagenCruz);
		getContentPane().add(labelCerrar);
		mapa = new Mapa();
		getContentPane().add(mapa);

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
				// No tiene uso
			}
		});

		cont = new ContadorTiempo(mapa, this);
		cont.start();
	}

	public void menuGanar() {
		/* Limpio la GUI */
		getContentPane().removeAll();
		getContentPane().repaint();
		
		/* Inicialización de los label. */
		JLabel comienzo = new JLabel();
		comienzo.setVerticalAlignment(SwingConstants.TOP);
		comienzo.setHorizontalAlignment(SwingConstants.CENTER);
		JLabel ganaste = new JLabel();

		ganaste.setBounds(822, 219, imagenPerdiste.getIconWidth(), imagenPerdiste.getIconHeight());
		ganaste.setAlignmentX(Component.CENTER_ALIGNMENT);
		ganaste.setHorizontalAlignment(SwingConstants.CENTER);

		comienzo.setBounds(875, 514, imagenJugar.getIconWidth(), imagenJugar.getIconHeight());

		JLabel salir = new JLabel();
		salir.setBounds(882, 831, 157, 52);

		comienzo.setIcon(imagenJugar);
		salir.setIcon(imagenSalir);
		ganaste.setIcon(imagenGanaste);

		/* Inicialización del fondo del menú. */
		JLabel fondo = new JLabel();
		fondo.setLocation(0, 0);
		fondo.setSize(1920, 1080);
		fondo.setIcon(fondoMenu);

		/* Meto todo en el panel */
		Container panel = getContentPane();
		panel.setLayout(null);
		panel.add(comienzo);
		panel.setComponentZOrder(comienzo, 0);
		panel.add(ganaste);
		panel.setComponentZOrder(ganaste, 0);
		panel.add(salir);
		panel.setComponentZOrder(salir, 0);
		panel.add(fondo);

		comienzo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				jugar();
			}

		});

		salir.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				System.exit(DISPOSE_ON_CLOSE);
			}
		});
	}
	
	public void menuPerder() {
		/* Limpio la GUI */
		getContentPane().removeAll();
		getContentPane().repaint();
		
		/* Inicialización de los label. */
		JLabel comienzo = new JLabel();
		comienzo.setVerticalAlignment(SwingConstants.TOP);
		comienzo.setHorizontalAlignment(SwingConstants.CENTER);
		JLabel perdiste = new JLabel();

		perdiste.setBounds(822, 219, imagenPerdiste.getIconWidth(), imagenPerdiste.getIconHeight());
		perdiste.setAlignmentX(Component.CENTER_ALIGNMENT);
		perdiste.setHorizontalAlignment(SwingConstants.CENTER);

		comienzo.setBounds(870, 514, imagenJugar.getIconWidth(), imagenJugar.getIconHeight());

		JLabel salir = new JLabel();
		salir.setBounds(882, 831, 157, 52);

		comienzo.setIcon(imagenJugar);
		salir.setIcon(imagenSalir);
		perdiste.setIcon(imagenPerdiste);

		/* Inicialización del fondo del menú. */
		JLabel fondo = new JLabel();
		fondo.setLocation(0, 0);
		fondo.setSize(1920, 1080);
		fondo.setIcon(fondoMenu);

		/* Meto todo en el panel */
		Container panel = getContentPane();
		panel.setLayout(null);
		panel.add(comienzo);
		panel.setComponentZOrder(comienzo, 0);
		panel.add(perdiste);
		panel.setComponentZOrder(perdiste, 0);
		panel.add(salir);
		panel.setComponentZOrder(salir, 0);
		panel.add(fondo);

		comienzo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				jugar();
			}

		});

		salir.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				System.exit(DISPOSE_ON_CLOSE);
			}
		});
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI g= new GUI();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}