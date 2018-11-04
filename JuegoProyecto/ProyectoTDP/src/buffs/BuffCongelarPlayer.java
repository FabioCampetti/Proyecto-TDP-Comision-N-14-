package buffs;

import javax.swing.ImageIcon;

import colliders.BuffCongelarPlayerCollider;

/*Esto es más un debuff que un buff*/
public class BuffCongelarPlayer extends Buff {

	private ImageIcon imagenBuff = new ImageIcon(this.getClass().getResource("/buffs/ImagenBuffCongelarPlayer.png"));;
	
	public BuffCongelarPlayer(int x,int y) {
		super();
		this.pos.setBounds(x,y,ancho,alto);
		this.pos.setIcon(imagenBuff);
		velocidad=10;
		pos.setIcon(imagenBuff);
		myCollider= new BuffCongelarPlayerCollider();
	}
}
