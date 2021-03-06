package colliders;
import disparos.DisparoJugador;
import naves.Jugador;
import obstaculos.ObstaculoTodos;

public class EnemigoCollider extends DefaultCollider {
	public EnemigoCollider(int da�o) {
		super(da�o);
	}
	
	@Override
	public void collideJugador(Jugador j) {
		j.recibirDa�o(da�o);
	}
	@Override
	public void collideDisparoJugador(DisparoJugador d) {
		d.morir();
	}
	@Override
	public void collideObstaculoTodos(ObstaculoTodos o) {
		o.morir();
	}
}
