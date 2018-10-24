package Naves;

import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import colliders.DefaultCollider;
import colliders.KamikazeCollider;
import inteligencias.IKamikazeAleatorio;
import inteligencias.IKamikazeDirigido;

public class Kamikaze extends Enemigo {
	public static final int ancho = 85;
	public static final int alto= 130;
	
	private ImageIcon foto = new ImageIcon(this.getClass().getResource("/Naves/EnemigoKamikaze.png"));
	private JLabel posJugador;
	
	public Kamikaze(JLabel p) {
		super();
		velocidad=5;
		pos.setBounds(50,50,ancho,alto);
		pos.setVisible(true);
		pos.setIcon(foto);
		daño=10;
		myCollider = new KamikazeCollider(daño);
		posJugador=p;
		
		
		Random r=new Random();
		int res=r.nextInt(10);
		if(res<7) {
			convertirAleatorio();
			score = 30;
		}
		else {
			convertirDirigido();
			score = 40;
		}	
	}
	public void mover(int x) {
		IA.mover(this);
	}
	
	private void convertirAleatorio() {
		IA = new IKamikazeAleatorio();
	}
	private void convertirDirigido() {
		IA = new IKamikazeDirigido(posJugador);
	}
	public void colision(Entidad e) {
		e.aceptar(myCollider);
	}
	public void aceptar(DefaultCollider c) {
		c.collideEnemigo(this);
	}
	public int getScore() {
		return score;
	}
	public void recibirDaño(int daño) {
		vida-=daño;
		if (vida<50) {
			Random rand=new Random();
			int cambioInteligencia = rand.nextInt(10);
			if (cambioInteligencia<7)
				IA=new IKamikazeAleatorio();
		}
	}
}
