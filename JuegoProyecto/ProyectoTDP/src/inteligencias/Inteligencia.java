package inteligencias;
import javax.swing.JLabel;

import Naves.Entidad;

public abstract class Inteligencia {

	protected int velocidad;
	public Inteligencia(int velocidad) {this.velocidad=velocidad;}
	public void mover(Entidad e) {}
}
