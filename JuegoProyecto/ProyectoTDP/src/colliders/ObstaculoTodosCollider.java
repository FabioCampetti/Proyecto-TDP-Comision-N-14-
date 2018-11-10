package colliders;

import disparos.DisparoEnemigo;
import disparos.DisparoJugador;
import naves.Enemigo;
import naves.Jugador;

public class ObstaculoTodosCollider extends DefaultCollider {
	public ObstaculoTodosCollider(int da�o) {
		super(da�o);
	}
	
	@Override
	public void collideEnemigo(Enemigo e) {
		e.recibirDa�o(da�o);
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
		j.recibirDa�o(da�o);
	}
}
