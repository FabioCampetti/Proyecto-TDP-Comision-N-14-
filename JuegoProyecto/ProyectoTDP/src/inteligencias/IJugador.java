package inteligencias;

import java.awt.event.KeyEvent;
import java.util.LinkedList;
import java.util.Queue;

import javax.swing.JLabel;

import mapas.Mapa;
import naves.Entidad;
import naves.Jugador;

public class IJugador extends Inteligencia {
	protected Queue<Integer> sigMovs;
	private static final int left = KeyEvent.VK_LEFT;
	private static final int right = KeyEvent.VK_RIGHT;
	private static final int up = KeyEvent.VK_UP;
	private static final int down = KeyEvent.VK_DOWN;

	public IJugador() {
		sigMovs = new LinkedList<Integer>();
	}

	@Override
	public void mover(Entidad e) {
		// TODO Auto-generated method stub
		int dir, velocidad;
		JLabel pos = e.getPosicion();

		if (!sigMovs.isEmpty())
			dir = sigMovs.remove();
		else
			dir = 0;

		velocidad = e.getVelocidad();

		if (dir == left) {
			if (pos.getX() > 0)
				pos.setLocation(pos.getX() - velocidad, pos.getY());
		} else if (dir == right) {
			if (pos.getX() < Mapa.ANCHO - Jugador.ancho)
				pos.setLocation(pos.getX() + velocidad, pos.getY());

		} else if (dir == up) {
			if (pos.getY() > 0)
				pos.setLocation(pos.getX(), pos.getY() - velocidad);
		} else if (dir == down) {
			if (pos.getY() < Mapa.ALTO - Jugador.alto - 35)
				pos.setLocation(pos.getX(), pos.getY() + velocidad);
		}
	}

	public void addMove(int dir) {
		sigMovs.add(dir);
	}

	private void emptyMoves() {
		sigMovs.clear();
	}

	public boolean noMoves() {
		return (sigMovs.isEmpty());
	}

}
