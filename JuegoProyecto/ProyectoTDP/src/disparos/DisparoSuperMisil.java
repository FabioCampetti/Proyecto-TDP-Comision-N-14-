package disparos;

import javax.swing.ImageIcon;

import colliders.DefaultCollider;
import colliders.SuperMisilCollider;
import inteligencias.IDisparoSuperMisil;
import naves.Entidad;

public class DisparoSuperMisil extends Disparo {

	public static final int ancho = 18;
	public static final int alto = 1080;

	private ImageIcon imagenDisparo = new ImageIcon(this.getClass().getResource("/disparos/SuperLaser.gif"));

	public DisparoSuperMisil(int x, int y) {
		super();
		this.pos.setBounds(x, y, ancho, 18);
		this.pos.setIcon(imagenDisparo);
		velocidad = 10;
		daño = 50;
		myCollider = new SuperMisilCollider(daño);

		/* Inteligencia de disparo estandar ya que se mueve igual que todos. */

		myInteligencia = new IDisparoSuperMisil();
	}

	public void mover() {
		myInteligencia.mover(this);
	}

	public void colision(Entidad e) {
		e.aceptar(myCollider);
	}

	public void aceptar(DefaultCollider c) {
		c.collideSuperMisil(this);
	}

	public void congelar() {
	};

}
