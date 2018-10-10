package Mapas;


import java.util.Random;

import javax.swing.JLabel;

import Naves.Enemigo;
import Naves.EnemigoArmado;
import Naves.Kamikaze;
import obstaculos.Obstaculo;
import obstaculos.ObstaculoJugador;
import obstaculos.ObstaculoTodos;

public class factoryLevelOne extends enemiesFactory {
	
	
	
	public factoryLevelOne(JLabel p) {
		kamikazeAmount = 10;
		armadoAmount = 20;
		obstaclesAmount = 4;
		size = 34;
		posJugador = p;
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
