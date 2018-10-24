package disparos;

import java.util.Collection;
import java.util.LinkedList;
import java.util.Random;

import naves.EnemigoArmado;
import naves.Entidad;

public class ArmaEnemigoEstandar extends Arma {

	public ArmaEnemigoEstandar(Entidad e) {
		quienDisparo=e;
	}
	
	public Collection<Disparo> disparar() {
		int val=(int) (EnemigoArmado.ancho*0.5);
		Collection<Disparo> res= new LinkedList<Disparo>();
		Random rand = new Random();
		int voyADisparar = rand.nextInt(1000);
		if (voyADisparar<3)
			res.add(new DisparoEnemigo(quienDisparo.getPosicion().getX()+val , quienDisparo.getPosicion().getY()+val ));
		return res;
	} 

	@Override
	public void recargar() {
		/* El enemigo tiene disparo ilimitados, no necesita recargar. */
	}

}
