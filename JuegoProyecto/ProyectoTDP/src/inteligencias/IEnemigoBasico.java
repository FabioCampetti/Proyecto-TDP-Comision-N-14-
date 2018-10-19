package inteligencias;

import java.util.Random;

import javax.swing.JLabel;

import Mapas.Mapa;
import Naves.EnemigoArmado;
import Naves.Entidad;

public class IEnemigoBasico extends Inteligencia{
	
	public IEnemigoBasico(int velocidad) {
		super(velocidad);
	}
	public void mover(Entidad e) {
		JLabel pos = e.getPosicion();
		Random r=new Random();
		int dir=r.nextInt(2);
		if (dir==0) {
			if(pos.getX()>25)
				pos.setLocation(pos.getX()-velocidad, pos.getY());
		}
		else {
			if(pos.getX()<Mapa.ANCHO-EnemigoArmado.ancho)
				pos.setLocation(pos.getX()+velocidad, pos.getY());
		}
	}
}
