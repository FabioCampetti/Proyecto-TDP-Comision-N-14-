package Disparos;

import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.ImageIcon;

public class DisparoJugador extends Disparo {
	
	/**
	 * DISPARO IMPLEMENTADO CON POCOS DETALLES - ICONO DE BOLA AZUL.
	 * PROBLEMA: EL DISPARO QUEDA ABAJO DEL FONDO DEL MAPA - PREGUNTAR
	 */
	
	public DisparoJugador(int x,int y) {
		super(x,y);
		ImageIcon imagen = new ImageIcon();
		try {
			URL direccion = new URL("file:///C://Users//Sandra//Documents//Proyecto-TDP-Comision-N-14-//JuegoProyecto//ProyectoTDP//src//Disparos/kameha2.png");
			imagen = new ImageIcon(direccion);
		}
		catch(MalformedURLException w) {
			w.printStackTrace();
		}
		this.pos.setIcon(imagen);
	}
	/**
	 * ACOMODAR TODO - PREGUNTAR SOBRE TREAD PARA VER MOVIMIENTO MÁS REAL.
	 */
	public void mover(int x) {
		//pos.setLocation(pos.getX(),pos.getY() - 350);
		
		while(pos.getY() >	0) {
			pos.setLocation(pos.getX(),pos.getY() - 10);
		}
		
		
	}
	
}
