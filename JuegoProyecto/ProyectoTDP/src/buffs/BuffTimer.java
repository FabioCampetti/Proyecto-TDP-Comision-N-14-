package buffs;

import mapas.Mapa;

public abstract class BuffTimer {
	public int timeLeft;
	
	public void updateBuff(Mapa m) {
		timeLeft--;
		if (timeLeft<=0) {
			terminarBuff(m);
		}
	}
	public boolean terminoBuff() {
		return (timeLeft<=0);
	}
	public abstract void terminarBuff(Mapa m);
	
}
