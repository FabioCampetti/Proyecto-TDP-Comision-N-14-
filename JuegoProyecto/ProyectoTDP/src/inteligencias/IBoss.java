package inteligencias;

import javax.swing.JLabel;

import mapas.Mapa;
import naves.EnemigoBoss;
import naves.Entidad;
import naves.Jugador;

public class IBoss extends Inteligencia {
	private int timeDown;
	private boolean goLeft = true;
	private boolean goDown = true;
	private float aceleracion;
	public IBoss() {
		timeDown = 100;
		aceleracion=1;
	}

	@Override
	public void mover(Entidad e) {
		JLabel pos = e.getPosicion();
		if (timeDown == 1) {
			aceleracion=1;
		}
		if (timeDown == 0) {
			goDown(e);
		} else {
			int x = e.getPosicion().getX();
			int y = e.getPosicion().getY();
			if (goLeft) {
				pos.setLocation(x - e.getVelocidad(), y);
				if (pos.getX() <= 0) {
					goLeft = false;
				}
			} else {
				pos.setLocation(x + e.getVelocidad(), y);
				if (pos.getX() >= Mapa.ANCHO - EnemigoBoss.ancho) {
					goLeft = true;
				}
			}
			timeDown--;
		}
	}

	private void goDown(Entidad e) {
		JLabel pos = e.getPosicion();
		int x = e.getPosicion().getX();
		int y = e.getPosicion().getY();
		int velocidad= (int) (e.getVelocidad()*aceleracion);
		if (goDown) {
			pos.setLocation(x, y + velocidad);
			if (pos.getY() >= Mapa.ALTO-Jugador.alto-EnemigoBoss.alto) {
				goDown = false;
			}
			aceleracion*=1.1;
		}
		else {
			pos.setLocation(x, y - velocidad);
			if (pos.getY() <= 0) {
				timeDown=200;
				goDown=true;
			}
			aceleracion/=1.1;
		}
	
	}
}
