package inteligencias;
import javax.swing.JLabel;

public abstract class Inteligencia {
	protected static final int anchoJugadores=125;
	protected static final int altoJugadores=125;
	
	protected int velocidad;
	public Inteligencia(int velocidad) {this.velocidad=velocidad;}
	public void mover(JLabel pos) {}
}
