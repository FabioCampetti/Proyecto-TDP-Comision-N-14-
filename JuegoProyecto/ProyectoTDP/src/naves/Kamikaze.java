package naves;

import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import colliders.DefaultCollider;
import colliders.KamikazeCollider;
import inteligencias.IKamikazeAleatorio;
import inteligencias.IKamikazeDirigido;

public class Kamikaze extends Enemigo {
	public static final int ancho = 92;
	public static final int alto = 92;

	private ImageIcon foto = new ImageIcon(this.getClass().getResource("/naves/ImagenEnemigo1FF.png"));
	private JLabel posJugador;

	public Kamikaze(JLabel p) {
		super();
		velocidad = 5;
		pos.setBounds(50, 50, ancho, alto);
		pos.setVisible(true);
		pos.setIcon(foto);
		daño = 10;
		myCollider = new KamikazeCollider(daño);
		posJugador = p;

		Random r = new Random();
		int res = r.nextInt(10);
		if (res < 7) {
			convertirAleatorio();
			score = 30;
		} else {
			convertirDirigido();
			score = 40;
		}
	}

	@Override
	public void mover() {
		IA.mover(this);
	}

	private void convertirAleatorio() {
		IA = new IKamikazeAleatorio();
	}

	private void convertirDirigido() {
		IA = new IKamikazeDirigido(posJugador);
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
	public void recibirDaño(int daño) {
		vida -= daño;
		if (vida < 50) {
			Random rand = new Random();
			int cambioInteligencia = rand.nextInt(10);
			if (cambioInteligencia < 7)
				IA = new IKamikazeAleatorio();
		}
	}
}
