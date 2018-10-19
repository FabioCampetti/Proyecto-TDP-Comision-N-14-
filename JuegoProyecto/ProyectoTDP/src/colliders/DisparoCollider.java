package colliders;

import Disparos.DisparoEnemigo;
import Disparos.DisparoJugador;
import Naves.Enemigo;
import Naves.Jugador;
import obstaculos.*;

public class DisparoCollider extends DefaultCollider {
	
	public DisparoCollider(int daño) {
		super(daño);
	}
	
	public void collideEnemigo(Enemigo e) {
		e.recibirDaño(daño);
	}
	public void collideObstaculoTodos(ObstaculoTodos o) {
		o.recibirDaño(daño);
	}
	
	public void collideObstaculoJugador(ObstaculoJugador o) {
		o.recibirDaño(daño);
	}
	public void collideDisparoEnemigo(DisparoEnemigo d) {
		d.morir();
	}
}
