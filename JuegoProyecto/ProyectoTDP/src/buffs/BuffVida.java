package buffs;

import java.awt.MenuComponent;

import javax.swing.ImageIcon;

import Mapas.Mapa;
import colliders.BuffArmaCollider;
import colliders.BuffVidaCollider;

public class BuffVida extends Buff {
	
	private ImageIcon imagenBuff = new ImageIcon(this.getClass().getResource("/buffs/ImagenBuffVida.jpg"));
	
	public BuffVida(int x, int y) {
		super();
		this.pos.setBounds(x,y,ancho,alto);
		this.pos.setIcon(imagenBuff);
		velocidad=10;
		pos.setIcon(imagenBuff);
		timeLeft = 25;
		myCollider= new BuffVidaCollider();
		
	}
	public void terminarBuff(Mapa m) {
		this.morir();
	}
	public void updateBuff(Mapa m) {
		timeLeft--;
		int nuevaVida = m.getJugador().getVida() + 3;
		m.getJugador().setVida(nuevaVida);
		if (timeLeft<=0) {
			terminarBuff(m);
		}
	}
	
}
