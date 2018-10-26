package buffs;

import disparos.ArmaJugadorEstandar;
import mapas.Mapa;

public class BuffTimerMisil extends BuffTimer{
	
	public BuffTimerMisil() {
		timeLeft = 30;
	}

	public void terminarBuff(Mapa m) {
		m.getJugador().cambiarArma(new ArmaJugadorEstandar(m.getJugador()));
	}

}
