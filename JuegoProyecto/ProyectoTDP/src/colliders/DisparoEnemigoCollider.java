package colliders;

import disparos.DisparoJugador;
import naves.Jugador;
import obstaculos.ObstaculoTodos;

public class DisparoEnemigoCollider extends DefaultCollider {
	
	public DisparoEnemigoCollider(int daño) {
		super(daño);
	}
	public void collideObstaculoTodos(ObstaculoTodos o) {
		o.recibirDaño(daño);
	}
	public void collideJugador(Jugador j) {
		j.recibirDaño(daño);
	}
	public void collideDisparoJugador(DisparoJugador d) {
		d.morir();
	}
}
