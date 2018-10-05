package Mapas;


import javax.swing.JLabel;

import Naves.Enemigo;
import Naves.EnemigoArmado;
import Naves.Kamikaze;

public class factoryLevelOne extends enemiesFactory {
	
	
	
	public factoryLevelOne(JLabel p) {
		kamikazeAmount = 10;
		armadoAmount = 20;
		size = 30;
		posJugador=p;
	}
	public enemiesFactory getNextFactory() {
		return new factoryLevelTwo(posJugador);
	}
	public Enemigo createEnemy() {
		if(armadoAmount!=0) {
			size--;
			armadoAmount--;
			return new EnemigoArmado();
		}
		if(kamikazeAmount!=0) {
			size--;
			kamikazeAmount--;
			return new Kamikaze(posJugador);
		}
		//Caso que la factory no pueda crear enemigos que es improbable.
		else
			return null;
	}
}
