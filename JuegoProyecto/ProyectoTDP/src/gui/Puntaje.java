package gui;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JLabel;
import javax.swing.JProgressBar;

import mapas.Mapa;

public class Puntaje {
	private JLabel labelPuntaje, labelMaximo,labelDisparos;
	private JProgressBar barraVida;
	private int puntaje;
	private int puntajeMaximo;
	//private File almacenamiento = new File("PuntajeMaximo.txt");

	public Puntaje(int vida) {

		/** Inicialización label que almacena el puntaje
		 * 	Se inserta en la punta derecha de la pantalla.
		 *  */
		labelPuntaje = new JLabel();
		labelPuntaje.setBounds(Mapa.ANCHO-100,0, 150, 50);
		labelPuntaje.setText("Puntuacion: 0");
		labelPuntaje.setForeground(Color.WHITE);
		
		/**Inicialización label que mostrara los disparos restantes del jugador
		 * Se insertará en la punta derecha inferior de la pantalla.
		 * */
		labelDisparos = new JLabel();
		labelDisparos.setBounds(Mapa.ANCHO-100,Mapa.ALTO-80,150,75);
		labelDisparos.setText("Disparos: 10/10");
		labelDisparos.setForeground(Color.WHITE);

		/** Inicialización barra que mantendra la vida del jugador
		 * 	Se inserta en la punta izquierda de la pantalla.
		 *  */
		barraVida = new JProgressBar(JProgressBar.HORIZONTAL, 0, 100);
		barraVida.setForeground(Color.RED);
		barraVida.setBounds(10,10, 200, 25);
		barraVida.setValue(vida);

		/** Inicialización del puntaje máximo obtenido del archivo 
		 * 	Se inserta en el medio de la pantalla.
		 * */
		iniciarMaximo();
		labelMaximo = new JLabel();
		labelMaximo.setBounds(Mapa.ANCHO/2 - 75, 0, 150, 50);
		labelMaximo.setText("Puntaje máximo: " + puntajeMaximo);
		labelMaximo.setForeground(Color.WHITE);

		puntaje = 0;
	}

	private void iniciarMaximo() {
		try {
			BufferedReader br = new BufferedReader(new FileReader("PuntajeMaximo.txt"));
			String st = "";

			st = br.readLine();
			puntajeMaximo = Integer.parseInt(st);

			br.close();
		} catch (IOException e) {
			System.out.println(e.getStackTrace());
		}
	}

	/**
	 * Método encargado de actualizar el puntaje máximo del archivo en caso que el
	 * jugador lo haya sobrepasado
	 */
	public void checkUpdate() {
		if (puntaje > puntajeMaximo) {
			puntajeMaximo = puntaje;
			try {
				String st = Integer.toString(puntajeMaximo);
				FileWriter fr = new FileWriter("PuntajeMaximo.txt");
				fr.write(st);
				fr.close();
			} catch (IOException e) {
				System.out.println(e.getStackTrace());
			}
		}
	}

	public void actualizarVida(int v) {
		barraVida.setValue(v);
	}

	public void actualizarPuntaje(int p) {
		puntaje += p;
		labelPuntaje.setText("Puntación: " + puntaje);
	}
	
	public void actualizarRestantes(int restantes) {
		labelDisparos.setText("Disparos: "+restantes+"/10");
	}
	
	public JLabel getLabelScore() {
		return labelPuntaje;
	}
	
	public JLabel getLabelDisparos() {
		return labelDisparos;
	}
	
	public JLabel getLabelMaximo() {
		return labelMaximo;
	}

	public int getPuntaje() {
		return puntaje;
	}

	public JProgressBar getBarraVida() {
		return barraVida;
	}

	public int getPuntajeMax() {
		return puntajeMaximo;
	}
	
}
