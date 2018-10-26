package buffs;

import disparos.ArmaJugadorEstandar;
import mapas.Mapa;

public class BuffTimerArma extends BuffTimer {
	public BuffTimerArma() {
		timeLeft=60;
	}
	public void terminarBuff(Mapa m) {
		m.getJugador().cambiarArma(new ArmaJugadorEstandar(m.getJugador()));
	}
}
