package inteligencias;
import javax.swing.JLabel;

import Mapas.Mapa;
import Naves.Entidad;
import Naves.Kamikaze;

import java.util.Random;

public class IKamikazeAleatorio extends Inteligencia {
	
	
	
	public IKamikazeAleatorio(int velocidad) {
		super(velocidad);
	}
	public void mover(Entidad e) {
		JLabel pos = e.getPosicion();
		Random r=new Random();
		int dir=r.nextInt(4);
		switch(dir){
		case 0 : //Arriba
			if(pos.getY()>Kamikaze.alto)
			pos.setLocation(pos.getX(), pos.getY()-velocidad);
			break;
		case 1 : //Abajo
			int posY = (pos.getY() + velocidad) % Mapa.ALTO;
			pos.setLocation(pos.getX(), posY);
			break;
		case 2 : //Izquierda
			if(pos.getX()>Kamikaze.ancho)
			pos.setLocation(pos.getX()-velocidad, pos.getY());
			break;
		case 3 : //Derecha
			if(pos.getX()<1890)
			pos.setLocation(pos.getX()+velocidad, pos.getY());
			break;
		}
		
		
		
	}
}
