package obstaculos;
import javax.swing.ImageIcon;

import naves.Entidad;

public abstract class Obstaculo extends Entidad {
	
	protected ImageIcon foto;
	
	public Obstaculo() {
		super();
		
		pos.setVisible(true);
		vida = 100;
	}
}
