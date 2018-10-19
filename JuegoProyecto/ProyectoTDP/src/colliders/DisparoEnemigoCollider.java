package colliders;

import Disparos.DisparoJugador;
import Naves.Enemigo;
import Naves.Jugador;
import obstaculos.ObstaculoJugador;
import obstaculos.ObstaculoTodos;

public class DisparoEnemigoCollider extends DefaultCollider {
	
	public DisparoEnemigoCollider(int da�o) {
		super(da�o);
	}
	public void collideObstaculoTodos(ObstaculoTodos o) {
		o.recibirDa�o(da�o);
	}
	public void collideJugador(Jugador j) {
		j.recibirDa�o(da�o);
	}
	public void collideDisparoJugador(DisparoJugador d) {
		d.morir();
	}
}
