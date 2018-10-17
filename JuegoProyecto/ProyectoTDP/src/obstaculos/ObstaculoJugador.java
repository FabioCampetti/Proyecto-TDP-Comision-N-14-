package obstaculos;

import javax.swing.ImageIcon;

import Naves.Entidad;
import colliders.DefaultCollider;
import colliders.ObstaculoJugadorCollider;

public class ObstaculoJugador extends Obstaculo {
	public ObstaculoJugador() {
		super();
		foto = new ImageIcon(this.getClass().getResource("/obstaculos/black hole.png"));
		pos.setIcon(foto);
		daño=20;
		myCollider = new ObstaculoJugadorCollider(daño);
	}
	public void mover(int x) {}
	@Override
	public void colision(Entidad e) {
		// TODO Auto-generated method stub
		e.aceptar(myCollider);
	}
	@Override
	public void aceptar(DefaultCollider c) {
		// TODO Auto-generated method stub
		c.collideObstaculoJugador(this);
	}

}
