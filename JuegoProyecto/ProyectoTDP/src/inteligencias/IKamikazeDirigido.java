package inteligencias;

import javax.swing.JLabel;

import Mapas.Mapa;
import Naves.Entidad;

public class IKamikazeDirigido extends Inteligencia {
	
	JLabel pos_player;
	
	public IKamikazeDirigido(JLabel p, int velocidad) {
		super(velocidad);
		pos_player=p;
	}
	
	public void mover(Entidad e) {
		JLabel pos = e.getPosicion();
		int xJug,xEnem;
		xJug=pos_player.getX();
		xEnem=pos.getX();
		int y = (pos.getY() + velocidad) % Mapa.ALTO;
		
		if (xEnem<xJug+50){ //Jugador esta mas a la derecha
			int x = (xEnem + velocidad) % Mapa.ANCHO;
			pos.setLocation(x,y);
		}
		else if(xEnem>xJug+50) { //Jugador esta mas a la izquierda
			int x = (xEnem - velocidad) % Mapa.ANCHO;
			pos.setLocation(x,y);
		}
		else { //Jugador esta a la misma altura en x
			pos.setLocation(xEnem, y);
		}
	}
}
