package Disparos;
import java.util.Collection;
import java.util.LinkedList;
import Naves.Entidad;
import Naves.Jugador;

public class ArmaJugadorEstandar extends Arma {
	
	public ArmaJugadorEstandar(Entidad e) {
		quienDisparo=e;
		disparosRestantes=5;
	}
	public Collection<Disparo> disparar() {
		Collection<Disparo> disparos=new LinkedList<Disparo>();
		if (disparosRestantes>0) {
			int val=(int) (Jugador.ancho*0.5);
			disparos.add(new DisparoJugador(quienDisparo.getPosicion().getX()+val, quienDisparo.getPosicion().getY() ));
			disparosRestantes--;
		}
		return disparos;
	}
	public void recargar() {
		disparosRestantes=5;
	}	

}
