package Mapas;

import Naves.Enemigo;
import Naves.EnemigoArmado;
import Naves.Kamikaze;

public class factoryLevelTwo extends enemiesFactory {
	public factoryLevelTwo() {
		kamikazeAmount = 20;
		armadoAmount = 20;
		size = 40;
	}
	public enemiesFactory getNextFactory() {
		//CASO QUE HAYA UN NIVEL 3 - ACA IRÍA LA FACTORY DEL LEVE3.
		return null;
	}
	public Enemigo createEnemy() {
		if (armadoAmount != 0) {
			size--;
			armadoAmount--;
			return new EnemigoArmado();
		}
		if (kamikazeAmount != 0) {
			size--;
			kamikazeAmount--;
			return new Kamikaze();
		}
		// Caso que la factory no pueda crear enemigos que es improbable.
		else
			return null;
	}
}
