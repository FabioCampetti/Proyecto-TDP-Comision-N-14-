package Naves;

import javax.swing.ImageIcon;

import colliders.DefaultCollider;
import colliders.EnemigoCollider;
import inteligencias.IKamikazeAleatorio;

public class Kamikaze extends Enemigo {
	
	private ImageIcon foto = new ImageIcon(this.getClass().getResource("/Naves/enemigo.gif"));
	
	public Kamikaze() {
		super();
		pos.setBounds(50,50,200,144);
		pos.setVisible(true);
		pos.setIcon(foto);
<<<<<<< HEAD
		coll=new EnemigoCollider();
		IA= new IKamikazeAleatorio();		
=======
		myCollider=new EnemigoCollider();
		IA= new IKamikazeAleatorio();
		
>>>>>>> f685a433d6c851c9fbf5d24465a1aaf9e91ebff8
	}
	public void mover(int x) {
		IA.mover(pos);
	}
	public void morir() {
		this.pos.setVisible(false);
		this.pos.setIcon(null);
	}
	
	public void colision(Entidad e) {
		e.aceptar(myCollider);
	}
	
	public void aceptar(DefaultCollider c) {
		c.collideEnemigo(this);
	}
}
