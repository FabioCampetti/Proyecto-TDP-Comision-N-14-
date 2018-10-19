package buffs;

import javax.swing.ImageIcon;

import Disparos.ArmaJugadorEstandar;
import Mapas.Mapa;
import colliders.BuffArmaCollider;

public class BuffArma extends Buff {
	private ImageIcon imagenBuff = new ImageIcon(this.getClass().getResource("/buffs/ImagenBuff (1).jpg"));
	
	
	public BuffArma(int x, int y) {
		super();
		this.pos.setBounds(x,y,ancho,alto);
		this.pos.setIcon(imagenBuff);
		velocidad=10;
		pos.setIcon(imagenBuff);
		timeLeft=25;
		myCollider= new BuffArmaCollider();
	}


	public void terminarBuff(Mapa m) {
		m.getJugador().cambiarArma(new ArmaJugadorEstandar(m.getJugador()));
		this.morir();
	}
	

}
