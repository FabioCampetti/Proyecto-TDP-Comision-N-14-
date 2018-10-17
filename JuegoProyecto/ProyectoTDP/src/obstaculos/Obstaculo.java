package obstaculos;
import javax.swing.ImageIcon;

import Naves.Entidad;

public abstract class Obstaculo extends Entidad {
	private static final int ancho = 299;
	private static final int largo= 153;
	protected ImageIcon foto;
	
	public Obstaculo() {
		super();
		pos.setBounds(200,500,ancho,largo);
		pos.setVisible(true);
		vida = 100;
	}
}
