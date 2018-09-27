package gui;
import Mapas.*;
import java.awt.EventQueue;
import javax.swing.JFrame;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GUI extends JFrame {
	protected Mapa mapa;
	private ContadorTiempo cont;
	/**
	 * Inicializacion de GUI con listeners para las flechitas.
	 * @param mapa JPanel que almacenara jugadores,enemigos, obstaculos,etc.
	/**
	 * Inicializacion del juego en si. Se crea frame principal y se le pega el JPanel del mapa.
	 */
	public GUI() {
	
		mapa = new Mapa();
		this.add(mapa);
		
		
		this.addKeyListener(new KeyListener() {
			public void keyPressed(KeyEvent e) {
				int aux = e.getKeyCode();  
				if(aux == KeyEvent.VK_SPACE) {
					mapa.disparoPlayer();
				}
				else if(aux == KeyEvent.VK_P) {
					mapa.killEnemigos();
				}
				else {
					mapa.movePlayer(aux);
					}
			}
			public void keyReleased(KeyEvent e) { }
			public void keyTyped(KeyEvent e) { }
		});
		
		this.setSize(1920,1080);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		cont = new ContadorTiempo(mapa,this);
		cont.start();

		
	}
	
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
