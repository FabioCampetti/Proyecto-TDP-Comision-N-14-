package buffs;

import escudos.EscudoEstandar;
import mapas.Mapa;

public class BuffTimerEscudo extends BuffTimer {

	public BuffTimerEscudo() {
		timeLeft=100;
	}
	public void terminarBuff(Mapa m) {
		m.getJugador().setEscudo(new EscudoEstandar());
		m.getJugador().setImagenesDefault();
	}
	
}
