package Mapas;

import java.util.LinkedList;
import java.util.Random;

public abstract class Mapa {
	protected Casilla[][] matriz;
	protected LinkedList<Enemigo> Enemigos;
	protected LinkedList<Obstaculo> Obstaculos;
	protected Jugador jugador;

	public Mapa(int cant_Kamikaze,int cant_Enemigos_Arma int cant_Obstaculos) {
		Random ran=new Random();
		
		//Inicializar matriz de casillas
		matriz=new Casilla[50][21];
		for (int i=0; i<50; i++) {
			for (int j=0; j<21; j++) {
				matriz[i][j]=new Casilla(i,j);
			}
		}
		
		//Inicializar Jugador
		jugador = new Jugador(matriz[49][10]);
		
		//Inicializar obstaculos
		Obstaculos = new LinkedList<Obstaculo>();
		for (int i=0; i<cant_Obstaculos; i++) {
			//Crear objeto Obstaculo y añadirlo a la lista
			Obstaculo obs=new Obstaculo(/*falta definir si le ponemos tamaño o que*/);
			Obstaculos.addLast(obs);
			
		}
		
		//Inicializar Enemigos
		Enemigos= new LinkedList<Enemigo>();
		for (int i=0; i<cant_Enemigos_Kamikaze; i++) {
			int tipo_Kamikaze= ran.nextInt(3);
			switch (tipo_Kamikaze) {
			case 0: {
				// En este caso se crea el kamikaze direccionado
				KamikazeDireccionado kam= new KamikazeDireccionado(matriz[2][i%21]);
				Enemigos.addLast(kam);
				break;
			}
			case 1: {
				// En este caso se crea el kamikaze con movimiento aleatorio
				KamikazeAleatorio kam= new KamikazeAleatorio(matriz[2][i%21]);
				Enemigos.addLast(kam);
				break;
			}
			case 2: {
				// En este caso se crea el kamikaze que se transforma de dirigido a aleatorio
				KamikazeTransforma kam= new KamikazeTransforma(matriz[2][i%21]);
				Enemigos.addLast(kam);
				break;
			}
			}
		}
		for (int i=0; i<cant_Enemigos_Arma; i++) {
			int tipo_Armado = ran.nextInt(2);
			if (tipo_Armado==0) {
				// En este caso se crea el enemigo con arma que luego la pierde y se transforma en kamikaze
				EnemigoArmadoTransforma enem= new EnemigoArmadoTransforma(matriz[3][i]);
				Enemigos.addLast(enem);
			}
			else {
				// En este caso se crea el enemigo con arma todo el tiempo
				EnemigoArmado enem= new EnemigoArmado(matriz[3][i]);
				Enemigos.addLast(enem);
			}
		}
		
	}
	
	
}
