package Mapas;


import Naves.Enemigo;
import Naves.EnemigoArmado;
import Naves.Kamikaze;

public class factoryLevelOne extends enemiesFactory {
	
	public factoryLevelOne() {
		kamikazeAmount = 20;
		armadoAmount = 10;
		size = 30;
	}
	public enemiesFactory getNextFactory() {
		return new factoryLevelTwo();
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
			return new Kamikaze();
		}
		//Caso que la factory no pueda crear enemigos que es improbable.
		else
			return null;
	}
}
