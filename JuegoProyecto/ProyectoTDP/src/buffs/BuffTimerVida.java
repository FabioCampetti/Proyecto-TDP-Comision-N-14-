package buffs;

import Mapas.Mapa;

public class BuffTimerVida extends BuffTimer{
	public BuffTimerVida() {
		timeLeft=60;
	}
	public void terminarBuff(Mapa m) {
	}
	
	public void updateBuff(Mapa m) {
		timeLeft--;
		int nuevaVida = m.getJugador().getVida() + 1;
		m.getJugador().setVida(nuevaVida);
	}
}
