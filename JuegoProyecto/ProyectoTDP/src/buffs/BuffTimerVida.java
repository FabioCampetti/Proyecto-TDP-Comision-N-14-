package buffs;

import mapas.Mapa;

public class BuffTimerVida extends BuffTimer{
	public BuffTimerVida() {
		timeLeft=70;
	}
	public void terminarBuff(Mapa m) {
		/* El buff de vida no hace nada en especial al terminar */
	}
	
	public void updateBuff(Mapa m) {
		timeLeft--;
		int nuevaVida = m.getJugador().getVida() + 1;
		m.getJugador().setVida(nuevaVida);
	}
}
