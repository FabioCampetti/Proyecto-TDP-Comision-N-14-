package colliders;

import disparos.DisparoEnemigo;
import disparos.DisparoJugador;
import naves.Enemigo;
import naves.Jugador;

public class ObstaculoTodosCollider extends DefaultCollider {
	public ObstaculoTodosCollider(int daño) {
		super(daño);
	}
	
	public void collideEnemigo(Enemigo e) {
		e.recibirDaño(daño);
	}
	
	public void collideDisparoJugador(DisparoJugador d) {
		d.morir();
	}
	public void collideDisparoEnemigo(DisparoEnemigo d) {
		d.morir();
	}
	public void collideJugador(Jugador j) {
		j.recibirDaño(daño);
	}
}
