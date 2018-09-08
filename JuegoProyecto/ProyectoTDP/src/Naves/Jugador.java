package Naves;

import java.awt.Color;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import Disparos.*;
import Mapas.Mapa;

public class Jugador extends Entidad {

	private static final int left = KeyEvent.VK_LEFT;
	private static final int right = KeyEvent.VK_RIGHT;

	public Jugador() {
		super();
		//Rectangle aux = pos.getBounds();
		//aux.setSize(150,200);
		pos.setBounds(700,240,350,350);
		//disparo = new DisparoJugador();
		pos.setVisible(true);

		ImageIcon imagen = new ImageIcon();
		try {
			//URL direccion = new URL("file:///C:/Users/Sandra/Desktop/123asd/Tennis/src/Juego/perdiste.png");
			URL direccion = new URL("file:///C:/Users/Sandra/Documents/Proyecto-TDP-Comision-N-14-/JuegoProyecto/ProyectoTDP/src/Naves/foto.png");
			imagen = new ImageIcon(direccion);
		}
		catch(MalformedURLException p ) {
		}
		pos.setIcon(imagen);
		//pos.setSize(50, 50);
	}

	public void mover(int x) {
		if (x == left) {
			{if(pos.getX()> - 60)
			pos.setLocation(pos.getX() - 20, pos.getY());}
		}
		else 
			if(pos.getX()< Mapa.ANCHO)
				if (x == right)
					pos.setLocation(pos.getX() + 20, pos.getY());

	}

}
