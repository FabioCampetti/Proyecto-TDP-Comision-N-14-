package obstaculos;

import javax.swing.ImageIcon;

import Naves.Entidad;
import colliders.DefaultCollider;
import colliders.ObstaculoTodosCollider;

public class ObstaculoTodos extends Obstaculo{
	public ObstaculoTodos() {
		super();
		foto=new ImageIcon(this.getClass().getResource("/obstaculos/Muro_de_Ladrillos.png"));
		pos.setIcon(foto);
		myCollider = new ObstaculoTodosCollider(this);
	}
	public void mover(int x) {}
	@Override
	public void colision(Entidad e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void aceptar(DefaultCollider c) {
		// TODO Auto-generated method stub
		c.collideObstaculoTodos(this);
	}
}
