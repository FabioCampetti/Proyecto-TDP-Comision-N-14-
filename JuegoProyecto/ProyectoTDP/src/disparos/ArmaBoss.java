package disparos;

import java.util.Collection;
import java.util.LinkedList;
import java.util.Random;

import javax.swing.JLabel;

import naves.EnemigoBoss;
import naves.Entidad;

public class ArmaBoss extends Arma {
	private JLabel posJugador;

	public ArmaBoss(Entidad e, JLabel p) {
		quienDisparo = e;
		posJugador = p;
	}

	@Override
	public Collection<Disparo> disparar() {
		int val = (int) (EnemigoBoss.ancho * 0.5);
		int myX = quienDisparo.getPosicion().getX();
		int myY = quienDisparo.getPosicion().getY() + val;
		Collection<Disparo> res = new LinkedList<Disparo>();
		Random rand = new Random();
		int voyADisparar = rand.nextInt(250);
		if (voyADisparar < 3) {
			for (int i = 0; i < 3; i++) {
				res.add(new DisparoEnemigo(myX, myY));
				myX+=val;
			}
			myX= quienDisparo.getPosicion().getX();
			for (int i = 0; i < 3; i++) {
				res.add(new DisparoEnemigoDirigido(myX, myY, posJugador));
				myX+=val;
			}
		}
		return res;
	}

	@Override
	public void recargar() {
		// TODO Auto-generated method stub

	}

}
