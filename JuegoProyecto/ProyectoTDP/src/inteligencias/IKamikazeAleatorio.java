package inteligencias;
import javax.swing.JLabel;

import Mapas.Mapa;
import Naves.Entidad;
import Naves.Kamikaze;

import java.util.Random;

public class IKamikazeAleatorio extends Inteligencia {
	private int dir;
	private int cantMovimientosSiguientes;
	
	public IKamikazeAleatorio() {
		super();
		cantMovimientosSiguientes=0;
		dir=0;
	}
	public void mover(Entidad e) {
		JLabel pos = e.getPosicion();
		int velocidad=e.getVelocidad();
		if(cantMovimientosSiguientes==0) {
			Random r=new Random();
			dir=r.nextInt(4);
			cantMovimientosSiguientes=15;
		}
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
		
		cantMovimientosSiguientes--;
		
	}
}
