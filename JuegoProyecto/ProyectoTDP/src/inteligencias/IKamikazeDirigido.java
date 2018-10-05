package inteligencias;

import javax.swing.JLabel;

import Mapas.Mapa;

public class IKamikazeDirigido extends Inteligencia {
	
	JLabel pos_player;
	
	public IKamikazeDirigido(JLabel p, int velocidad) {
		super(velocidad);
		pos_player=p;
	}
	
	public void mover(JLabel pos) {
		int xJug,xEnem;
		xJug=pos_player.getX();
		xEnem=pos.getX();
		
		if (xEnem<xJug){ //Jugador esta mas a la derecha
			int x = (xEnem + velocidad) % Mapa.ANCHO;
			int y = (pos.getY() + velocidad) % Mapa.LARGO;
			pos.setLocation(x,y);
		}
		else if(xEnem>xJug) { //Jugador esta mas a la izquierda
			int x = (xEnem - velocidad) % Mapa.ANCHO;
			int y = (pos.getY() + velocidad) % Mapa.LARGO;
			pos.setLocation(x,y);
			
		}
	}
}
