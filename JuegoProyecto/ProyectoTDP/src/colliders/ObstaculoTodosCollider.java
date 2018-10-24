package colliders;

import Disparos.DisparoEnemigo;
import Disparos.DisparoJugador;
import Naves.Enemigo;
import Naves.Jugador;

public class ObstaculoTodosCollider extends DefaultCollider {
	public ObstaculoTodosCollider(int da�o) {
		super(da�o);
	}
	
	public void collideEnemigo(Enemigo e) {
		e.recibirDa�o(da�o);
	}
	
	public void collideDisparoJugador(DisparoJugador d) {
		d.morir();
	}
	public void collideDisparoEnemigo(DisparoEnemigo d) {
		d.morir();
	}
	public void collideJugador(Jugador j) {
		j.recibirDa�o(da�o);
	}
}
