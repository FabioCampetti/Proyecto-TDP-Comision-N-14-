package Naves;

import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import colliders.DefaultCollider;
import colliders.EnemigoCollider;
import inteligencias.*;

public class Kamikaze extends Enemigo {
	
	private ImageIcon foto = new ImageIcon(this.getClass().getResource("/Naves/enemigo.gif"));
	private JLabel posJugador;
	
	public Kamikaze(JLabel p) {
		super();
		velocidad=10;
		pos.setBounds(50,50,200,144);
		pos.setVisible(true);
		pos.setIcon(foto);
		myCollider = new EnemigoCollider(this);
		posJugador=p;
		
		Random r=new Random();
		int res=r.nextInt(10);
		if(res<7) {
			convertirAleatorio();
		}
		else {
			convertirDirigido();
		}	
	}
	public void mover(int x) {
		IA.mover(pos);
	}
	public void morir() {
		vida=0;
	}
	public void convertirAleatorio() {
		IA = new IKamikazeAleatorio(velocidad);
	}
	public void convertirDirigido() {
		IA = new IKamikazeDirigido(posJugador,velocidad);
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
