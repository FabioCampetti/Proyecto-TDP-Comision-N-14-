package Naves;

import javax.swing.ImageIcon;

import colliders.EnemigoCollider;

public class EnemigoArmado extends Enemigo {

	private ImageIcon foto = new ImageIcon(this.getClass().getResource("/Naves/armado.gif"));

	public EnemigoArmado() {
		super();
		pos.setBounds(50,50,200,200);
		pos.setVisible(true);
		pos.setIcon(foto);
		coll = new EnemigoCollider();	
	}
	/**
	 * TODO
	 */
	public void mover(int x) {
	}
	public void morir() {
		this.pos.setVisible(false);
		this.pos.setIcon(null);
	}
}
