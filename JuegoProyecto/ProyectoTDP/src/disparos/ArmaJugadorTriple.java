package disparos;

import java.util.Collection;
import java.util.LinkedList;

import inteligencias.IDisparoDiagonalDer;
import inteligencias.IDisparoDiagonalIzq;
import naves.Entidad;
import naves.Jugador;
import sonidos.GameSound;

public class ArmaJugadorTriple extends Arma {
	public ArmaJugadorTriple(Entidad e) {
		quienDisparo = e;
		disparosRestantes = 10;
	}

	@Override
	public Collection<Disparo> disparar() {
		Collection<Disparo> disparos = new LinkedList<Disparo>();
		int val = 10;
		if (disparosRestantes > 0) {
			Disparo d = new DisparoJugador(quienDisparo.getPosicion().getX() + val, quienDisparo.getPosicion().getY());
			d.cambiarInteligencia(new IDisparoDiagonalIzq());
			disparos.add(d);
			val += Jugador.ancho / 3;
			d = new DisparoJugador(quienDisparo.getPosicion().getX() + val, quienDisparo.getPosicion().getY());
			disparos.add(d);
			val += Jugador.ancho / 3;
			d = new DisparoJugador(quienDisparo.getPosicion().getX() + val, quienDisparo.getPosicion().getY());
			d.cambiarInteligencia(new IDisparoDiagonalDer());
			disparos.add(d);
			val += Jugador.ancho / 3;
			
			GameSound.DISPARO.play();
		}
		else {
			GameSound.NO_BALAS.play();
		}
		
		disparosRestantes--;
		return disparos;
	}

	@Override
	public void recargar() {
		disparosRestantes = 10;
	}

}
