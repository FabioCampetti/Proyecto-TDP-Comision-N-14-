package escudos;

public class EscudoIndestructible extends Escudo{

	public EscudoIndestructible() {
		super();
	}
	@Override
	public int recibirDaño(int daño) {
		return 0;
	}

}
