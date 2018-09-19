package Naves;

public class EnemigoArmado extends Enemigo {

	public EnemigoArmado() {
		
	}
	public void mover(int x) {
		IA.mover(this.pos);
		
	}

}
