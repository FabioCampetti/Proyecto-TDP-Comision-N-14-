package inteligencias;
import javax.swing.JLabel;

import java.util.Random;

public class IKamikazeAleatorio extends Inteligencia {
	
	public IKamikazeAleatorio() {
		super();
	}
	public void mover(JLabel pos) {
		Random r=new Random();
		int dir=r.nextInt(4);
		switch(dir){
		case 0 : //Arriba
			if(pos.getY()>25)
			pos.setLocation(pos.getX(), pos.getY()-25);
			break;
		case 1 : //Abajo
			if(pos.getY()<700)
			pos.setLocation(pos.getX(), pos.getY()+25);
			break;
		case 2 : //Izquierda
			if(pos.getX()>25)
			pos.setLocation(pos.getX()-25, pos.getY());
			break;
		case 3 : //Derecha
			if(pos.getX()<1890)
			pos.setLocation(pos.getX()+25, pos.getY());
			break;
		}
		
		
		
	}
}
