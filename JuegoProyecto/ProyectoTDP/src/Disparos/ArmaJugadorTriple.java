package Disparos;

import java.util.Collection;
import java.util.LinkedList;

import Naves.Entidad;
import Naves.Jugador;

public class ArmaJugadorTriple extends Arma {
	public ArmaJugadorTriple(Entidad e) {
		quienDisparo = e;
		disparosRestantes = 15;
	}

	public Collection<Disparo> disparar() {
		Collection<Disparo> disparos = new LinkedList<Disparo>();
		int val = 10;
		if (disparosRestantes > 0) {
			for (int i = 0; i < 3; i++) {
				disparos.add(new DisparoJugador(quienDisparo.getPosicion().getX() + val, quienDisparo.getPosicion().getY()));
				val += Jugador.ancho / 3;
				disparosRestantes--;
			}
		}
		return disparos;
	}

	public void recargar() {
		disparosRestantes = 15;
	}

}
