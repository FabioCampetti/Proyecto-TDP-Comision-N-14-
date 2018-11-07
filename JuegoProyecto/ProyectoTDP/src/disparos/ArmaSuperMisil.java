package disparos;

import java.util.Collection;
import java.util.LinkedList;

import naves.Entidad;
import naves.Jugador;
import sonidos.GameSound;

public class ArmaSuperMisil extends Arma {

	public ArmaSuperMisil(Entidad e) {
		quienDisparo = e;
		disparosRestantes = 3;
	}
	
	public Collection<Disparo> disparar() {
		Collection<Disparo> disparos=new LinkedList<Disparo>();
		if (disparosRestantes>0) {
			int val=(int) (Jugador.ancho*0.5);
			disparos.add(new DisparoSuperMisil(quienDisparo.getPosicion().getX()+val, quienDisparo.getPosicion().getY() ));
			disparosRestantes--;
			GameSound.DISPARO_LASER.play();
		}
		else {
			GameSound.NO_BALAS.play();
		}
		return disparos;
	}
	
	public void recargar() {
		disparosRestantes = 3;
	}
	
}
