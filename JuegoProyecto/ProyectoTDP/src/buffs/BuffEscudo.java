package buffs;

import javax.swing.ImageIcon;

import colliders.BuffEscudoCollider;

public class BuffEscudo extends Buff {
	
	private ImageIcon imagenBuff = new ImageIcon(this.getClass().getResource("/buffs/ImagenBuffEscudo.png"));
	
	public BuffEscudo(int x, int y) {
		super();
		this.pos.setBounds(x,y,ancho,alto);
		this.pos.setIcon(imagenBuff);
		velocidad=10;
		pos.setIcon(imagenBuff);
		myCollider= new BuffEscudoCollider(0);
	}
}
