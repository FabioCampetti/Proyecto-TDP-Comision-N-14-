package Naves;

import javax.swing.ImageIcon;

import colliders.DefaultCollider;
import colliders.EnemigoCollider;
import inteligencias.IEnemigoBasico;

public class EnemigoArmado extends Enemigo {

	private ImageIcon foto = new ImageIcon(this.getClass().getResource("/Naves/armado.gif"));

	public EnemigoArmado() {
		super();
		
		pos.setBounds(50,50,200,200);
		pos.setVisible(true);
		pos.setIcon(foto);
		IA=new IEnemigoBasico(velocidad);
		myCollider = new EnemigoCollider(this);	
	}
	
	public void mover(int x) {
		IA.mover(pos);
	}
	
	public void morir() {
		vida=0;
	}
	
	public void colision(Entidad e) {
		e.aceptar(myCollider);
		
	}
	
	public void aceptar(DefaultCollider c) {
		c.collideEnemigo(this);
	}
	public int getScore() {
		return 75;
	}
	
}
