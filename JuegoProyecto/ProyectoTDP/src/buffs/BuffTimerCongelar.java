package buffs;

import Mapas.Mapa;

public class BuffTimerCongelar extends BuffTimer {

	public BuffTimerCongelar() {
		timeLeft=60;
	}
	
	public void updateBuff(Mapa m) {
		if (timeLeft==60) {
			m.congelar();
		}
		timeLeft--;
		if (timeLeft<=0) {
			terminarBuff(m);
		}
	}
	
	public void terminarBuff(Mapa m) {
		m.descongelar();
	}

}
