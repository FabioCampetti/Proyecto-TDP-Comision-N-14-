package inteligencias;
import javax.swing.JLabel;

public abstract class Inteligencia {
	protected int velocidad;
	public Inteligencia(int velocidad) {this.velocidad=velocidad;}
	public void mover(JLabel pos) {}
}
