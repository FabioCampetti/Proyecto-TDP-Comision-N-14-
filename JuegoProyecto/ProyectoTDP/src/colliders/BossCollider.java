package colliders;

import naves.Jugador;

public class BossCollider extends DefaultCollider {

	public BossCollider(int da�o) {
		super(da�o);
		// TODO Auto-generated constructor stub
	}

	public void collideJugador(Jugador j) {
		//Aca que va que le pasa al jugador cuando es chocado por el boss
		j.recibirDa�o(da�o);
	}
}
