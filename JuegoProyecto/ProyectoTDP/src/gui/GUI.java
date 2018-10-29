package gui;

import java.awt.EventQueue;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import mapas.Mapa;
import javax.swing.SwingConstants;
import java.awt.Component;
import java.awt.event.MouseAdapter;

public class GUI extends JFrame {
	protected Mapa mapa;
	private ContadorTiempo cont;

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

		JFrame frameAux = new JFrame();
		frameAux.setSize(1920, 1080);
		frameAux.setUndecorated(true);
		frameAux.setResizable(false);
		ImageIcon imagenJugar = new ImageIcon(this.getClass().getResource("/gui/JugarDeNuevo.png"));
		ImageIcon imagenSalir = new ImageIcon(this.getClass().getResource("/gui/Salir.png"));
		ImageIcon imagenPerdiste = new ImageIcon(this.getClass().getResource("/gui/GameOver.png"));
		ImageIcon fondoMenu = new ImageIcon(this.getClass().getResource("/gui/FondoMenu.jpg"));

		/** Inicialización de los label. */
		JLabel comienzo = new JLabel();
		comienzo.setVerticalAlignment(SwingConstants.TOP);
		comienzo.setHorizontalAlignment(SwingConstants.CENTER);
		JLabel instrucciones = new JLabel();

		instrucciones.setBounds(807, 219, imagenPerdiste.getIconWidth(), imagenPerdiste.getIconHeight());
		instrucciones.setAlignmentX(Component.CENTER_ALIGNMENT);
		instrucciones.setHorizontalAlignment(SwingConstants.CENTER);

		comienzo.setBounds(720, 411, imagenJugar.getIconWidth(), imagenJugar.getIconHeight());

		JLabel salir = new JLabel();
		salir.setBounds(873, 628, 157, 52);

		comienzo.setIcon(imagenJugar);
		salir.setIcon(imagenSalir);
		instrucciones.setIcon(imagenPerdiste);

		/** Inicialización del fondo del menú. */
		JLabel fondo = new JLabel();
		fondo.setLocation(0, 0);
		fondo.setSize(1920, 1080);
		fondo.setIcon(fondoMenu);

		/** Creacion del panel y se le agrega el fondo */
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.add(comienzo);
		panel.setComponentZOrder(comienzo, 0);
		panel.add(instrucciones);
		panel.setComponentZOrder(instrucciones, 0);
		panel.add(salir);
		panel.setComponentZOrder(salir, 0);
		panel.add(fondo);

		frameAux.getContentPane().add(panel);
		frameAux.setVisible(true);
		comienzo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				frameAux.dispose();
				frameAux.dispatchEvent(new WindowEvent(frameAux, WindowEvent.WINDOW_CLOSING));
				GUI frame = new GUI();
				frame.dispose();
				frame.setUndecorated(true);
				frame.setVisible(true);
				frame.setFocusable(true);
				frame.setEnabled(true);

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
					JFrame frameAux = new JFrame();
					frameAux.setSize(1920, 1080);
					frameAux.setUndecorated(true);
					frameAux.setResizable(false);
					ImageIcon imagenJugar = new ImageIcon(this.getClass().getResource("/gui/Jugar.png"));
					ImageIcon imagenSalir = new ImageIcon(this.getClass().getResource("/gui/Salir.png"));
					ImageIcon imagenComoJugar = new ImageIcon(this.getClass().getResource("/gui/ComoJugar.png"));
					ImageIcon fondoMenu = new ImageIcon(this.getClass().getResource("/gui/FondoMenu.jpg"));

					/** Inicialización de los label. */
					JLabel comienzo = new JLabel();
					comienzo.setVerticalAlignment(SwingConstants.TOP);
					comienzo.setHorizontalAlignment(SwingConstants.CENTER);
					comienzo.setBounds(864, 219, 175, 52);
					JLabel instrucciones = new JLabel();
					instrucciones.setAlignmentX(Component.CENTER_ALIGNMENT);
					instrucciones.setHorizontalAlignment(SwingConstants.CENTER);
					instrucciones.setBounds(776, 411, 352, 52);
					JLabel salir = new JLabel();
					salir.setBounds(873, 628, 157, 52);

					comienzo.setIcon(imagenJugar);
					salir.setIcon(imagenSalir);
					instrucciones.setIcon(imagenComoJugar);

					/** Inicialización del fondo del menú. */
					JLabel fondo = new JLabel();
					fondo.setLocation(0, 0);
					fondo.setSize(1920, 1080);
					fondo.setIcon(fondoMenu);

					/** Creacion del panel y se le agrega el fondo */
					JPanel panel = new JPanel();
					panel.setLayout(null);
					panel.add(comienzo);
					panel.setComponentZOrder(comienzo, 0);
					panel.add(instrucciones);
					panel.setComponentZOrder(instrucciones, 0);
					panel.add(salir);
					panel.setComponentZOrder(salir, 0);
					panel.add(fondo);

					frameAux.getContentPane().add(panel);
					frameAux.setVisible(true);
					comienzo.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent arg0) {
							frameAux.dispose();
							frameAux.dispatchEvent(new WindowEvent(frameAux, WindowEvent.WINDOW_CLOSING));
							GUI frame = new GUI();
							frame.dispose();
							frame.setUndecorated(true);
							frame.setVisible(true);
							frame.setFocusable(true);
							frame.setEnabled(true);
						}

						
					});

					salir.addMouseListener(new MouseAdapter() {
						public void mouseClicked(MouseEvent e) {
							System.exit(DISPOSE_ON_CLOSE);
						}
					});

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}