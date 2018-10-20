package buffs;

import Disparos.ArmaJugadorEstandar;
import Mapas.Mapa;

public class BuffTimerArma extends BuffTimer {
	public BuffTimerArma() {
		timeLeft=40;
	}
	public void terminarBuff(Mapa m) {
		m.getJugador().cambiarArma(new ArmaJugadorEstandar(m.getJugador()));
	}
}
