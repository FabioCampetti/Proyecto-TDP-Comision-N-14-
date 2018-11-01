package colliders;

import naves.Jugador;

public class BossCollider extends DefaultCollider {

	public BossCollider(int daño) {
		super(daño);
		// TODO Auto-generated constructor stub
	}

	public void collideJugador(Jugador j) {
		//Aca que va que le pasa al jugador cuando es chocado por el boss
		j.recibirDaño(daño);
	}
}
