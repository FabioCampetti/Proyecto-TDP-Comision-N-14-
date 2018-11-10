package mapas;

import javax.swing.JLabel;

import naves.Enemigo;
import naves.EnemigoBoss;
import obstaculos.Obstaculo;

public class FactoryLevelThree extends EnemiesFactory {
	
	
	public FactoryLevelThree(JLabel pos) {
		armadoAmount=1;
		obstaclesAmount=0;
		size=1;
		posJugador=pos;
	}
	
	@Override
	public EnemiesFactory getNextFactory() {
		return null;
	}

	@Override
	public Enemigo createEnemy() {
		armadoAmount--;
		size--;
		return new EnemigoBoss(posJugador);
	}

	@Override
	public Obstaculo createObstacle() {
		return null;
	}

}
