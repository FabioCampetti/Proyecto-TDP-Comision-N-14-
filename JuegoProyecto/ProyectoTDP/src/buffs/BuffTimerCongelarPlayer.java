package buffs;

import mapas.Mapa;

public class BuffTimerCongelarPlayer extends BuffTimer {

	public BuffTimerCongelarPlayer() {
		timeLeft = 100;
	}

	@Override
	public void updateBuff(Mapa m) {
		if(timeLeft == 100)
			m.getJugador().slow();
		
		timeLeft--;
		
		if (timeLeft<=0) {
			terminarBuff(m);
		}
		
	}
	
	@Override
	public void terminarBuff(Mapa m) {
		m.getJugador().speedUp();
	}
	
}
