package buffs;

import javax.swing.ImageIcon;
import colliders.BuffMisilCollider;

public class BuffSuperMisil extends Buff {
	
	private ImageIcon imagenBuff = new ImageIcon(this.getClass().getResource("/buffs/superMisilBuff.png"));
	
	public BuffSuperMisil(int x, int y) {
		super();
		this.pos.setBounds(x,y,ancho,alto);
		this.pos.setIcon(imagenBuff);
		velocidad=10 ;
		pos.setIcon(imagenBuff);
		myCollider = new BuffMisilCollider();
	}

}
