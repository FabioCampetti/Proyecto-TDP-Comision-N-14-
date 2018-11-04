package buffs;

import mapas.Mapa;

public class BuffTimerCongelar extends BuffTimer {

	public BuffTimerCongelar() {
		timeLeft=70;
	}
	
	public void updateBuff(Mapa m) {
		m.congelar();
		timeLeft--;
		if (timeLeft<=0) {
			terminarBuff(m);
		}
	}
	
	public void terminarBuff(Mapa m) {
		m.descongelar();
	}

}
