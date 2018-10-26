package disparos;

import javax.swing.ImageIcon;

import colliders.DefaultCollider;
import colliders.SuperMisilCollider;
import inteligencias.IDisparoEstandar;
import naves.Entidad;

public class DisparoSuperMisil extends Disparo {
	
	public static final int ancho = 100;
	public static final int alto = 173;
	
	private ImageIcon imagenDisparo = new ImageIcon(this.getClass().getResource("/Disparos/superMisil.png"));
	
	public DisparoSuperMisil(int x,int y) {
		super();
		this.pos.setBounds(x,y,ancho,alto);
		this.pos.setIcon(imagenDisparo);
		velocidad = 10;
		daño = 50;
		myCollider = new SuperMisilCollider(daño);
		/**Inteligencia de disparo estandar ya que se mueve igual que todos.*/
		myInteligencia = new IDisparoEstandar();
	}
	
	public void mover(int x) {
		myInteligencia.mover(this);
	}

	public void colision(Entidad e) {
		e.aceptar(myCollider);
	}

	public void aceptar(DefaultCollider c) {
		c.collideSuperMisil(this);
	}

	
}
