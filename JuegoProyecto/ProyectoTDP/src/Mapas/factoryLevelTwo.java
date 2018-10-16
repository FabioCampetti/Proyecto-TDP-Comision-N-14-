package Mapas;

import java.util.Random;

import javax.swing.JLabel;

import Naves.Enemigo;
import Naves.EnemigoArmado;
import Naves.Kamikaze;
import obstaculos.Obstaculo;
import obstaculos.ObstaculoJugador;
import obstaculos.ObstaculoTodos;

public class factoryLevelTwo extends enemiesFactory {
	public factoryLevelTwo(JLabel p) {
		kamikazeAmount = 20;
		armadoAmount = 20;
		obstaclesAmount = 5;
		size = 45;
		posJugador = p;
	}
	
	public enemiesFactory getNextFactory() {
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
			return new Kamikaze(posJugador);
		}
		// Caso que la factory no pueda crear enemigos que es improbable.
		else
			return null;
	}
	
	public Obstaculo createObstacle() {
		Random ran=new Random();
		int a=ran.nextInt(3);
		if (obstaclesAmount!=0) {
			size--;
			obstaclesAmount--;
			if (a<1) {
				return new ObstaculoJugador();
			}
			else {
				return new ObstaculoTodos();
			}
		}
		else return null;
	}
}
