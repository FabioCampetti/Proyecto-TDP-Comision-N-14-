package colliders;

import disparos.DisparoJugador;
import naves.Jugador;
import obstaculos.ObstaculoTodos;

public class DisparoEnemigoCollider extends DefaultCollider {
	
	public DisparoEnemigoCollider(int da�o) {
		super(da�o);
	}
	@Override
	public void collideObstaculoTodos(ObstaculoTodos o) {
		o.recibirDa�o(da�o);
	}
	@Override
	public void collideJugador(Jugador j) {
		j.recibirDa�o(da�o);
	}
	@Override
	public void collideDisparoJugador(DisparoJugador d) {
		d.morir();
	}
}
