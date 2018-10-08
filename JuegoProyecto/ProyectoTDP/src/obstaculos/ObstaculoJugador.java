package obstaculos;

import Naves.Entidad;
import colliders.DefaultCollider;
import colliders.ObstaculoJugadorCollider;

public class ObstaculoJugador extends Obstaculo {
	public ObstaculoJugador() {
		super();
		myCollider = new ObstaculoJugadorCollider(this);
	}
	public void mover(int x) {
		
	}
	@Override
	public void colision(Entidad e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void aceptar(DefaultCollider c) {
		// TODO Auto-generated method stub
		
	}
}
