package disparos;

import javax.swing.ImageIcon;

import colliders.DefaultCollider;
import colliders.DisparoCollider;
import inteligencias.IDisparoEstandar;
import naves.Entidad;

public class DisparoJugador extends Disparo {
	public static final int ancho = 47;
	public static final int alto = 88;

	private ImageIcon imagenDisparo = new ImageIcon(this.getClass().getResource("/disparos/imagenDisparoJugador.png"));

	public DisparoJugador(int x, int y) {
		super();
		this.pos.setBounds(x, y, ancho, alto);
		this.pos.setIcon(imagenDisparo);
		velocidad = 10;
		da�o = 35;
		myCollider = new DisparoCollider(da�o);
		myInteligencia = new IDisparoEstandar();
	}

	@Override
	public void mover() {
		myInteligencia.mover(this);
	}

	@Override
	public void colision(Entidad e) {
		e.aceptar(myCollider);
	}

	@Override
	public void aceptar(DefaultCollider c) {
		c.collideDisparoJugador(this);
	}

	@Override
	public void congelar() {
	};
}
