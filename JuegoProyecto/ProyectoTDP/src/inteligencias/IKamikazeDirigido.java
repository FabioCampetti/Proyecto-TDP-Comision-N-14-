package inteligencias;

import javax.swing.JLabel;

import mapas.Mapa;
import naves.Entidad;
import naves.Kamikaze;

public class IKamikazeDirigido extends Inteligencia {

	private JLabel pos_player;

	public IKamikazeDirigido(JLabel p) {
		super();
		pos_player = p;
	}

	@Override
	public void mover(Entidad e) {
		JLabel pos = e.getPosicion();
		int xJug, 
			xEnem, 
			velocidad;
		
		velocidad = e.getVelocidad();
		xJug = pos_player.getX();
		xEnem = pos.getX();
		int y = (int) (pos.getY() + velocidad*0.75);
		
		if (y + Kamikaze.alto >= Mapa.ALTO)
			y = 0;

		if ((xEnem>xJug-10) && (xEnem<xJug+10)) {
			pos.setLocation(xEnem, y);
		}
		else if (xEnem < xJug ) { // Jugador esta mas a la derecha
			int x = (int) ((xEnem + velocidad*0.75) % Mapa.ANCHO);
			pos.setLocation(x, y);
		} else if (xEnem > xJug) { // Jugador esta mas a la izquierda
			int x = (int) ((xEnem - velocidad*0.75) % Mapa.ANCHO);
			pos.setLocation(x, y);
		} else { // Jugador esta a la misma altura en x
			pos.setLocation(xEnem, y);
		}
	}
}
