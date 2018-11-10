package mapas;


import java.util.Random;

import javax.swing.JLabel;

import naves.Enemigo;
import naves.EnemigoArmado;
import naves.Kamikaze;
import obstaculos.Obstaculo;
import obstaculos.ObstaculoJugador;
import obstaculos.ObstaculoTodos;

public class FactoryLevelOne extends EnemiesFactory {
	
	
	
	public FactoryLevelOne(JLabel p) {
		kamikazeAmount = 10;
		armadoAmount = 20;
		obstaclesAmount = 4;
		size = 34;
		posJugador = p;
	}
	
	@Override
	public EnemiesFactory getNextFactory() {
		return new FactoryLevelTwo(posJugador);
	}
	
	@Override
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
	
	@Override
	public Obstaculo createObstacle() {
		Random ran=new Random();
		int a=ran.nextInt(40);
		if (obstaclesAmount!=0) {
			size--;
			obstaclesAmount--;
			if (a<10) {
				return new ObstaculoJugador();
			}
			else {
				return new ObstaculoTodos();
			}
		}
		else return null;
	}
}
