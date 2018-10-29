package obstaculos;

import javax.swing.ImageIcon;

import colliders.DefaultCollider;
import colliders.ObstaculoTodosCollider;
import naves.Entidad;

public class ObstaculoTodos extends Obstaculo{
	private static final int ancho = 299;
	private static final int largo= 157;
	public ObstaculoTodos() {
		super();
		foto = new ImageIcon(this.getClass().getResource("/obstaculos/Obstaculo3.png"));
		pos.setIcon(foto);
		pos.setBounds(200,500,ancho,largo);
		daño=15;
		myCollider = new ObstaculoTodosCollider(daño);
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
		c.collideObstaculoTodos(this);
	}

}
