package colliders;

import disparos.DisparoEnemigo;
import disparos.DisparoJugador;
import naves.Enemigo;
import naves.Jugador;

public class ObstaculoTodosCollider extends DefaultCollider {
	public ObstaculoTodosCollider(int daño) {
		super(daño);
	}
	
	@Override
	public void collideEnemigo(Enemigo e) {
		e.recibirDaño(daño);
	}
	
	@Override
	public void collideDisparoJugador(DisparoJugador d) {
		d.morir();
	}
	@Override
	public void collideDisparoEnemigo(DisparoEnemigo d) {
		d.morir();
	}
	@Override
	public void collideJugador(Jugador j) {
		j.recibirDaño(daño);
	}
}
