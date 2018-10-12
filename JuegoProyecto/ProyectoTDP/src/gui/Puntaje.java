package gui;

import java.awt.Color;

import javax.swing.JLabel;

public class Puntaje {
	private JLabel labelPuntaje,labelVida;
	private int puntaje;
	private int vida;
	
	public Puntaje () {
		labelPuntaje=new JLabel();
		labelPuntaje.setBounds(25, 25, 150, 50);
		labelPuntaje.setText("Puntuacion: 0");
		labelPuntaje.setForeground(Color.WHITE);
		
		labelVida=new JLabel();
		labelVida.setBounds(25, 50, 150, 50);
		labelVida.setText("Vida actual: 100");
		labelVida.setForeground(Color.WHITE); 
	
		puntaje=0;
	}
	
	public void actualizarPuntaje(int p) {
		puntaje+=p;
		labelPuntaje.setText("Puntación: "+puntaje);
	}
	
	public void actualizarVida(int v) {
		vida=v;
		labelVida.setText("Vida actual: "+vida);
	}
	
	public JLabel getLabelScore() {
		return labelPuntaje;
	}
	
	public JLabel getLabelVida() {
		return labelVida;
	}
}
