package obstaculos;

import javax.swing.ImageIcon;

import colliders.DefaultCollider;
import colliders.ObstaculoJugadorCollider;
import naves.Entidad;

public class ObstaculoJugador extends Obstaculo {
	private static final int ancho = 299;
	private static final int largo= 153;
	public ObstaculoJugador() {
		super();
		foto = new ImageIcon(this.getClass().getResource("/obstaculos/black hole.png"));
		pos.setIcon(foto);
		pos.setBounds(200,500,ancho,largo);
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
