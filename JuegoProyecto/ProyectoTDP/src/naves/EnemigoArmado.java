package naves;

import java.util.Collection;
import java.util.Random;

import javax.swing.ImageIcon;

import colliders.DefaultCollider;
import colliders.EnemigoCollider;
import disparos.Arma;
import disparos.ArmaEnemigoEstandar;
import disparos.Disparo;
import inteligencias.IEnemigoBasico;
import inteligencias.IKamikazeAleatorio;

public class EnemigoArmado extends Enemigo {
	
	public static final int ancho = 100;
	public static final int alto= 88;
	private ImageIcon foto = new ImageIcon(this.getClass().getResource("/Naves/ImagenEnemigoArmado.png"));
	private Arma armaEnemigo;
	
	public EnemigoArmado() {
		super();
		velocidad=7;
		pos.setBounds(50,50,ancho,alto);
		pos.setVisible(true);
		pos.setIcon(foto);
		IA=IEnemigoBasico.getInstance();
		score = 75;
		daño=15;
		myCollider = new EnemigoCollider(daño);
		armaEnemigo = new ArmaEnemigoEstandar(this);
	}
	
	public void mover(int x) {
		IA.mover(this);
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
	
	public Collection<Disparo> disparar() {
		return armaEnemigo.disparar();
	}
	
	public void recibirDaño(int daño) {
		vida-=daño;
		if (vida<40) {
			Random rand=new Random();
			int cambioInteligencia = rand.nextInt(5);
			if (cambioInteligencia<1)
				IA=new IKamikazeAleatorio();
		}
	}
	
	
}
