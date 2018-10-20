package inteligencias;
import javax.swing.JLabel;
import Mapas.Mapa;
import Naves.EnemigoArmado;
import Naves.Entidad;

public class IEnemigoBasico extends Inteligencia{
	private int mover;
	public IEnemigoBasico(int velocidad) {
		super(velocidad);
		mover=0;
	}
	
	public void mover(Entidad e) {
		JLabel pos= e.getPosicion();
		
		if (mover<12) {
			if(pos.getX()<Mapa.ANCHO-EnemigoArmado.ancho)
				pos.setLocation(pos.getX()+velocidad, pos.getY());
			mover++;
			if (mover==12)
				mover=24;
		}
		
		if (mover>12) {
			if(pos.getX()>25)
				pos.setLocation(pos.getX()-velocidad, pos.getY());
			mover--;
			if (mover==12)
				mover=0;
		}
		
	}
}
