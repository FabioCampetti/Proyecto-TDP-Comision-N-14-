package naves;

import java.util.Collection;
import java.util.LinkedList;
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
	public static final int alto = 88;
	private ImageIcon foto = new ImageIcon(this.getClass().getResource("/naves/ImagenEnemigoArmado.png"));
	private Arma armaEnemigo;

	public EnemigoArmado() {
		super();
		velocidad = 7;
		pos.setBounds(50, 50, ancho, alto);
		pos.setVisible(true);
		pos.setIcon(foto);
		IA = IEnemigoBasico.getInstance();
		score = 75;
		daño = 15;
		myCollider = new EnemigoCollider(daño);
		armaEnemigo = new ArmaEnemigoEstandar(this);
	}

	@Override
	public void mover() {
		IA.mover(this);
	}

	@Override
	public void colision(Entidad e) {
		e.aceptar(myCollider);
	}

	@Override
	public void aceptar(DefaultCollider c) {
		c.collideEnemigo(this);
	}

	@Override
	public int getScore() {
		return score;
	}

	@Override
	public Collection<Disparo> disparar() {
		Collection<Disparo> res = new LinkedList<Disparo>();
		if (!isFrozen()) {
			res = armaEnemigo.disparar();
		}
		return res;
	}

	@Override
	public void recibirDaño(int daño) {
		vida -= daño;
		if (vida < 40) {
			Random rand = new Random();
			int cambioInteligencia = rand.nextInt(5);
			if (cambioInteligencia < 1)
				IA = new IKamikazeAleatorio();
		}
	}

}
