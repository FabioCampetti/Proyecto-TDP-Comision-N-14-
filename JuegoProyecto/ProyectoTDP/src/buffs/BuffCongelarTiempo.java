package buffs;

import javax.swing.ImageIcon;

import colliders.BuffArmaCollider;
import colliders.BuffCongelarCollider;

public class BuffCongelarTiempo extends Buff {
	
	private ImageIcon imagenBuff = new ImageIcon(this.getClass().getResource("/buffs/ImagenBuffCongelar.png"));
	
	public BuffCongelarTiempo(int x, int y) {
		super();
		this.pos.setBounds(x,y,ancho,alto);
		this.pos.setIcon(imagenBuff);
		velocidad=10;
		pos.setIcon(imagenBuff);
		myCollider= new BuffCongelarCollider(daño);
	}
}
