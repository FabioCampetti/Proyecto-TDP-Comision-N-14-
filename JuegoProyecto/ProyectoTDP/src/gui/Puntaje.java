package gui;

import java.awt.Color;
import java.io.*;

import javax.swing.JLabel;

public class Puntaje {
	private JLabel labelPuntaje, labelVida, labelMaximo;
	private int puntaje;
	private int vida;
	private int puntajeMaximo;
	private File almacenamiento =new File("/gui/Almacenamiento.txt");
	public Puntaje(int vida) {

		labelPuntaje = new JLabel();
		labelPuntaje.setBounds(25, 25, 150, 50);
		labelPuntaje.setText("Puntuacion: 0");
		labelPuntaje.setForeground(Color.WHITE);

		labelVida = new JLabel();
		labelVida.setBounds(25, 50, 150, 50);
		labelVida.setText("Vida actual: " + vida);
		labelVida.setForeground(Color.WHITE);

		iniciarMaximo();
		
		labelMaximo = new JLabel();
		labelMaximo.setBounds(25,0,150,50);
		labelMaximo.setText("Puntaje máximo: " + puntajeMaximo);
		labelMaximo.setForeground(Color.WHITE);
		
		puntaje = 0;
	}
	private void iniciarMaximo() {
		try {
			BufferedReader br = new BufferedReader(new FileReader(almacenamiento),0);

			String st = new String("");
			
			st = br.readLine();
			puntajeMaximo = Integer.parseInt(st);
			
			//almacenamiento.
			
			br.close();
		} catch (IOException e) {
			System.out.println(e.getStackTrace());
		}
	}
	/**
	 * Preguntar cómo escribir en el input stream.
	 */
	/*
	public void checkUpdate() {
		if(puntaje > puntajeMaximo) {
			puntajeMaximo = puntaje;
			try {
				System.out.println("Entre aca");
				String st = Integer.toString(puntajeMaximo);
				FileWriter fr = new FileWriter(almacenamiento,false);
				fr.write(st);
				fr.close();
			} catch (IOException e) {
				System.out.println(e.getStackTrace());
			}
		}
	}
	*/
	public void actualizarVida(int v) {
		vida = v;
		labelVida.setText("Vida actual: " + vida);
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
	public JLabel getLabelVida() {
		return labelVida;
	}
	public int getPuntajeMax() {
		return puntajeMaximo;
	}
}
