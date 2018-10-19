package gui;

import java.awt.Color;
import java.io.*;

import javax.swing.JLabel;
import javax.swing.JProgressBar;

public class Puntaje {
	private JLabel labelPuntaje, labelMaximo;
	private JProgressBar barraVida;
	private int puntaje;
	private int vida;
	private int puntajeMaximo;
	private File almacenamiento = new File("PuntajeMaximo.txt");

	public Puntaje(int vida) {

		/** Inicialización label que almacena el puntaje */
		labelPuntaje = new JLabel();
		labelPuntaje.setBounds(25, 25, 150, 50);
		labelPuntaje.setText("Puntuacion: 0");
		labelPuntaje.setForeground(Color.WHITE);

		/** Inicialización barra que mantendra la vida del jugador */
		barraVida = new JProgressBar(JProgressBar.HORIZONTAL, 0, 100);
		barraVida.setForeground(Color.RED);
		barraVida.setBounds(20, 60, 150, 25);
		barraVida.setValue(vida);

		/** Inicialización del puntaje máximo obtenido del archivo */
		iniciarMaximo();
		labelMaximo = new JLabel();
		labelMaximo.setBounds(25, 0, 150, 50);
		labelMaximo.setText("Puntaje máximo: " + puntajeMaximo);
		labelMaximo.setForeground(Color.WHITE);

		puntaje = 0;
	}

	private void iniciarMaximo() {
		try {
			BufferedReader br = new BufferedReader(new FileReader(almacenamiento));
			String st = new String("");

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
				FileWriter fr = new FileWriter(almacenamiento, false);
				fr.write(st);
				fr.close();
			} catch (IOException e) {
				System.out.println(e.getStackTrace());
			}
		}
	}

	public void actualizarVida(int v) {
		vida = v;
		barraVida.setValue(vida);
	}

	public void actualizarPuntaje(int p) {
		puntaje += p;
		labelPuntaje.setText("Puntación: " + puntaje);
	}

	public JLabel getLabelScore() {
		return labelPuntaje;
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
