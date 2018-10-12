package gui;

import java.awt.Color;

import javax.swing.JLabel;

public class Puntaje {
	private JLabel labelPuntaje;
	private int puntaje;
	
	public Puntaje () {
		labelPuntaje=new JLabel();
		labelPuntaje.setBounds(25, 25, 150, 50);
		labelPuntaje.setText("Puntuacion: 0");
		labelPuntaje.setForeground(Color.WHITE);
		puntaje=0;
	}
	
	public void actualizarPuntaje(int p) {
		puntaje+=p;
		labelPuntaje.setText("Puntación: "+puntaje);
	}
	
	public JLabel getLabelScore() {
		return labelPuntaje;
	}
}
