package disparos;

//import javax.swing.ImageIcon;
import javax.swing.JLabel;

import colliders.DefaultCollider;
import inteligencias.IDisparoDirigido;
import naves.Entidad;

public class DisparoEnemigoDirigido extends DisparoEnemigo {
	
	public static final int ancho = 7;
	public static final int alto = 45;

	public DisparoEnemigoDirigido(int x, int y, JLabel p) {
		super(x, y);
		myInteligencia = new IDisparoDirigido(p);
	}

	@Override
	public void mover() {
		myInteligencia.mover(this);
	}

	@Override
	public void colision(Entidad e) {
		e.aceptar(myCollider);
	}

	public void aceptar(DefaultCollider c) {
		c.collideDisparoEnemigo(this);
	}

}
