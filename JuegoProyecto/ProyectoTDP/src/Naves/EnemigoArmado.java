package Naves;

import java.util.Collection;
import java.util.Random;

import javax.swing.ImageIcon;

import Disparos.Arma;
import Disparos.ArmaEnemigoEstandar;
import Disparos.Disparo;
import Disparos.DisparoEnemigo;
import colliders.DefaultCollider;
import colliders.EnemigoCollider;
import inteligencias.IEnemigoBasico;
import inteligencias.IKamikazeAleatorio;

public class EnemigoArmado extends Enemigo {
	
	public static final int ancho = 132;
	public static final int alto= 135;
	private ImageIcon foto = new ImageIcon(this.getClass().getResource("/Naves/EnemigoArmado (1).gif"));
	private Arma armaEnemigo;
	
	public EnemigoArmado() {
		super();
		velocidad=10;
		pos.setBounds(50,50,ancho,alto);
		pos.setVisible(true);
		pos.setIcon(foto);
		IA=new IEnemigoBasico(velocidad);
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
				IA=new IKamikazeAleatorio(this.velocidad);
		}
	}
	
}
