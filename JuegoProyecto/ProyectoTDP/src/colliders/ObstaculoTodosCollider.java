package colliders;

import Disparos.DisparoEnemigo;
import Disparos.DisparoJugador;
import Naves.Enemigo;
import Naves.Entidad;
import Naves.Jugador;

public class ObstaculoTodosCollider extends DefaultCollider {
	public ObstaculoTodosCollider(Entidad e) {
		super(e);
	}
	public void collideEnemigo(Enemigo e) {
		//Hay que modelar que le sucede al obstaculo cuando choca con un enemigo
	}
	public void collideDisparo(DisparoJugador d) {
		//Hay que modelar
	}
	public void collideDisparo(DisparoEnemigo d) {}
}
