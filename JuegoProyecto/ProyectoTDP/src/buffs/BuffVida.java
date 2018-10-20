package buffs;

import javax.swing.ImageIcon;
import colliders.BuffVidaCollider;

public class BuffVida extends Buff {
	
	private ImageIcon imagenBuff = new ImageIcon(this.getClass().getResource("/buffs/ImagenBuffVida.png"));
	
	public BuffVida(int x, int y) {
		super();
		this.pos.setBounds(x,y,ancho,alto);
		this.pos.setIcon(imagenBuff);
		velocidad=10;
		pos.setIcon(imagenBuff);
		myCollider= new BuffVidaCollider();
		
	}
	
	
	
}
