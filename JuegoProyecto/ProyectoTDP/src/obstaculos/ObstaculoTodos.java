package obstaculos;

import javax.swing.ImageIcon;

import colliders.DefaultCollider;
import colliders.ObstaculoTodosCollider;
import naves.Entidad;

public class ObstaculoTodos extends Obstaculo{
	public ObstaculoTodos() {
		super();
		foto = new ImageIcon(this.getClass().getResource("/obstaculos/Muro_de_Ladrillos.png"));
		pos.setIcon(foto);
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
