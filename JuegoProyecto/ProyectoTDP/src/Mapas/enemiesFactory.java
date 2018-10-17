package Mapas;

import javax.swing.JLabel;

import Naves.Enemigo;
import obstaculos.Obstaculo;

/**
 */
public abstract class enemiesFactory {
	protected int size;
	protected int armadoAmount;
	protected int kamikazeAmount;
	protected int obstaclesAmount;
	protected JLabel posJugador;
	/**
	 * Todos los niveles comenzarán con 30 enemigos de distinto tipos.
	 */
	/**
	 * Chequea si la factory ya terminó de crear todos sus enemigos.
	 * @return verdadero si termino de crear todos los enemigos, falso en caso contrario
	 */
	public boolean isEmpty() {
		return size == 0;
	}
	
	public boolean noEnemies() {
		return (armadoAmount+kamikazeAmount) == 0;
	}
	
	public boolean noObstacles() {
		return obstaclesAmount == 0;
	}
	/**
	 * Llamado el método se modifica el tipo de factory
	 * @return tipo de factory al que se cambió.
	 */
	public abstract enemiesFactory getNextFactory();
	
	/**
	 * Creo un tipo de enemigo que decida.
	 * @return tipo de enemigo creado por la factory.
	 */
	public abstract Enemigo createEnemy();
	
	public abstract Obstaculo createObstacle();
}
