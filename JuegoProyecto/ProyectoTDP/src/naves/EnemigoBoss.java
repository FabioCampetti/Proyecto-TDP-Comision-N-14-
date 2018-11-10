package naves;

import java.util.Collection;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import colliders.BossCollider;
import colliders.DefaultCollider;
import disparos.Arma;
import disparos.ArmaBoss;
import disparos.Disparo;
import inteligencias.IBoss;

public class EnemigoBoss extends Enemigo {
	private JLabel posJugador;
	public static final int ancho = 262;
	public static final int alto = 299;
	private ImageIcon foto = new ImageIcon(this.getClass().getResource("/naves/Boss.png"));
	private Arma armaEnemigo;

	public EnemigoBoss(JLabel p) {
		super();
		velocidad = 7;
		vida = 1000;
		score = 1000;
		pos.setBounds(500, 50, ancho, alto);
		pos.setVisible(true);
		pos.setIcon(foto);
		daño = 10;
		myCollider = new BossCollider(daño);
		posJugador = p;
		IA = new IBoss();
		armaEnemigo = new ArmaBoss(this, posJugador);

	}

	@Override
	public Collection<Disparo> disparar() {
		Collection<Disparo> res = armaEnemigo.disparar();
		return res;
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
		c.collideBoss(this);
	}

	@Override
	public int getScore() {
		return score;
	}

}
