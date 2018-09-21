package Naves;

import javax.swing.ImageIcon;

import colliders.DefaultCollider;
import colliders.EnemigoCollider;
import inteligencias.*;

public class Kamikaze extends Enemigo {
	
	private ImageIcon foto = new ImageIcon(this.getClass().getResource("/Naves/enemigo.gif"));
	
	public Kamikaze() {
		super();
		pos.setBounds(50,50,200,144);
		pos.setVisible(true);
		pos.setIcon(foto);
		myCollider = new EnemigoCollider();
		
		IA= new IKamikazeAleatorio();		
	}
	public void mover(int x) {
		IA.mover(pos);
	}
	public void morir() {
		this.pos.setVisible(false);
		this.pos.setIcon(null);
	}
	public void convertirAleatorio() {
		IA = new IKamikazeAleatorio();
	}
	public void convertirDirigido() {
		IA = new IKamikazeDirigido();
	}
	public void colision(Entidad e) {
		e.aceptar(myCollider);
	}
	public void aceptar(DefaultCollider c) {
		c.collideEnemigo(this);
	}
	public int getScore() {
		return 30;
	}
}
