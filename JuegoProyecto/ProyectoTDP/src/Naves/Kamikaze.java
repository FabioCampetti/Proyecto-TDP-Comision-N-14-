package Naves;

import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import colliders.DefaultCollider;
import colliders.EnemigoCollider;
import inteligencias.*;

public class Kamikaze extends Enemigo {
	private static final int ancho = 85;
	private static final int alto= 130;
	
	private ImageIcon foto = new ImageIcon(this.getClass().getResource("/Naves/EnemigoKamikaze.png"));
	private JLabel posJugador;
	
	public Kamikaze(JLabel p) {
		super();
		velocidad=10;
		pos.setBounds(50,50,ancho,alto);
		pos.setVisible(true);
		pos.setIcon(foto);
		myCollider = new EnemigoCollider();
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
	
	public void convertirAleatorio() {
		IA = new IKamikazeAleatorio(velocidad*2);
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
