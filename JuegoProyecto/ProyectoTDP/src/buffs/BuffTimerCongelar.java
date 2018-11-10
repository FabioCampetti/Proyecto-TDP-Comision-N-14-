package buffs;

import mapas.Mapa;

public class BuffTimerCongelar extends BuffTimer {

	public BuffTimerCongelar() {
		timeLeft=70;
	}
	
	@Override
	public void updateBuff(Mapa m) {
		if(timeLeft == 70)
			m.congelar();
		
		timeLeft--;
		if (timeLeft<=0) {
			terminarBuff(m);
		}
	}
	
	@Override
	public void terminarBuff(Mapa m) {
		m.descongelar();
	}

}
