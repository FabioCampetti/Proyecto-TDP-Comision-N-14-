package colliders;

import Disparos.DisparoEnemigo;
import Disparos.DisparoJugador;
import Naves.Enemigo;
import Naves.Jugador;

public class ObstaculoTodosCollider extends DefaultCollider {
	public ObstaculoTodosCollider() {
		super();
	}
	public void collideEnemigo(Enemigo e) {
		//Hay que modelar que le sucede al obstaculo cuando choca con un enemigo
	}
	public void collideDisparoJugador(DisparoJugador d) {
		d.morir();

	}
	public void collideDisparoEnemigo(DisparoEnemigo d) {
		
	}
	public void collideJugador(Jugador j) {
		j.setVida(j.getVida()-10);
	}
}
