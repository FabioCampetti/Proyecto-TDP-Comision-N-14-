package inteligencias;

import javax.swing.JLabel;

import disparos.DisparoEnemigo;
import mapas.Mapa;
import naves.Entidad;
import naves.Jugador;

public class IDisparoDirigido extends Inteligencia {

	private JLabel pos_player;
	private float aceleracion = 1;

	public IDisparoDirigido(JLabel p) {
		super();
		pos_player = p;
	}

	public void mover(Entidad e) {
		JLabel pos = e.getPosicion();
		int xJug, xEnem, velocidad;

		velocidad = e.getVelocidad();
		xJug = pos_player.getX() + Jugador.ancho / 2;
		xEnem = pos.getX() + DisparoEnemigo.ancho / 2;
		int y = (int) (pos.getY() + velocidad * 0.75);
		if (y + DisparoEnemigo.alto >= Mapa.ALTO)
			e.morir();

		if ((xEnem > xJug) && (xEnem < xJug)) {
			pos.setLocation(xEnem, y);
		} else if (xEnem < xJug) { // Jugador esta mas a la derecha
			int x = (int) (((xEnem - DisparoEnemigo.ancho / 2) + velocidad * 0.80 * aceleracion) % Mapa.ANCHO);
			pos.setLocation(x, y);
		} else if (xEnem > xJug) { // Jugador esta mas a la izquierda
			int x = (int) (((xEnem - DisparoEnemigo.ancho / 2) - velocidad * 0.80 * aceleracion) % Mapa.ANCHO);
			pos.setLocation(x, y);
		} else { // Jugador esta a la misma altura en x
			pos.setLocation(xEnem, y);
		}
		aceleracion *= 0.99;
	}
}
