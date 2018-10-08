package obstaculos;
import javax.swing.ImageIcon;

import Naves.Entidad;

/*
 * Clase que hace de puente entre entidad y obstaculos? No se si tiene algun buen uso esto.	
 */
public abstract class Obstaculo extends Entidad {
	private static final int ancho = 299;
	private static final int largo= 153;
	private ImageIcon foto = new ImageIcon(this.getClass().getResource("/obstaculos/new obstacle.jpg"));
	
	public Obstaculo() {
		super();
		pos.setBounds(200,500,ancho,largo);
		pos.setVisible(true);
		pos.setIcon(foto);
		vida = 500;
	}
}
