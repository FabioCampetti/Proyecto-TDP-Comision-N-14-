package gui;
import Mapas.*;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GUI extends JFrame {
	protected Mapa mapa;
	private ContadorTiempo cont;
	private ImageIcon fondoMenu = new ImageIcon(this.getClass().getResource("/gui/fondoMenu.jpg"));
	/**
	 * Inicializacion de GUI con listeners para las flechitas.
	 * @param mapa JPanel que almacenara jugadores,enemigos, obstaculos,etc.
	/**
	 * Inicializacion del juego en si. Se crea frame principal y se le pega el JPanel del mapa.
	 */
	public GUI() {
	
		
		this.setTitle("Space Game");
		menu();
		this.setSize(500,500);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
	}
	public GUI(int x) {
		mapa = new Mapa();
		this.add(mapa);
		

		this.addKeyListener(new KeyListener() {
			public void keyPressed(KeyEvent e) {
				int aux = e.getKeyCode();  
				if(aux == KeyEvent.VK_SPACE) {
					mapa.disparoPlayer();
				}
				else {
					mapa.movePlayer(aux);
					}
			}
			public void keyReleased(KeyEvent e) { 
				mapa.setDefaultPlayerIcon();
			}
			public void keyTyped(KeyEvent e) { }
		});
		
		this.setSize(1920,1080);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		cont = new ContadorTiempo(mapa,this);
		cont.start();
	}
	/**Inicialización básica del menú.*/
	private void menu() {
		
	/**Inicialización de los botones. */
    JButton botonComienzo = new JButton("Comenzar");
    JButton instrucciones = new JButton("Cómo jugar");
    JButton salir = new JButton("Salir");
    /**Inicialización del fondo del menú. */
    JLabel fondo = new JLabel();
    fondo.setIcon(fondoMenu);
    
    /**Creacion del panel y se le agrega el fondo */
    JPanel panel = new JPanel();
    panel.add(fondo);
    
    /**Agregación de todos los botones al panel. */
    panel.setComponentZOrder(fondo,0);
    panel.add(botonComienzo);
    panel.setComponentZOrder(botonComienzo,0);
    panel.add(instrucciones);
    panel.setComponentZOrder(instrucciones,0);
    panel.add(salir);
    panel.setComponentZOrder(salir,0);
    
    this.add(panel);
    
    	/** Listener del boton comienzo. Básicamente se encarga de inicializar el juego en el segundo constructor de la GUI.
    	*/
        botonComienzo.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e){
        	  remove(panel);
        	  remove(botonComienzo);
        	  new GUI(2);
        	  
          }
        });
        /** Listener del boton salir. Cierra el juego/menú.
         */
        salir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
            	close();
            }
         });
        
	}
	private void close() {
		this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
	}
	
	/**
	 * Lanza la interfaz gráfica
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI frame = new GUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
}
