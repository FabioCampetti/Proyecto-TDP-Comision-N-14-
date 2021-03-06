package inteligencias;

import java.util.Random;

import javax.swing.JLabel;

import mapas.Mapa;
import naves.Entidad;
import naves.Kamikaze;

public class IKamikazeAleatorio extends Inteligencia {
	private int dir;
	private int cantMovimientosSiguientes;

	public IKamikazeAleatorio() {
		super();
		cantMovimientosSiguientes = 0;
		dir = 0;
	}

	@Override
	public void mover(Entidad e) {
		JLabel pos = e.getPosicion();
		int velocidad = e.getVelocidad();
		
		/* Mueve al kamikaze aleatoriamente, por un cierto tiempo. */
		
		if (cantMovimientosSiguientes == 0) {
			Random r = new Random();
			dir = r.nextInt(4);
			cantMovimientosSiguientes = 15;
		}
		switch (dir) {
		case 0: // Arriba
			if (pos.getY() - velocidad > 0)
				pos.setLocation(pos.getX(), pos.getY() - velocidad);
			break;
		case 1: // Abajo
			int posY = (pos.getY() + velocidad);
			if (posY + Kamikaze.alto >= Mapa.ALTO)
				posY = 0;
			pos.setLocation(pos.getX(), posY);
			break;
		case 2: // Izquierda
			if (pos.getX() > 0)
				pos.setLocation(pos.getX() - velocidad, pos.getY());
			break;
		case 3: // Derecha
			if (pos.getX() < Mapa.ANCHO - Kamikaze.ancho)
				pos.setLocation(pos.getX() + velocidad, pos.getY());
			break;
		default:
			/* por default no mueve */
		}

		cantMovimientosSiguientes--;

	}
}
