package buffs;

import javax.swing.ImageIcon;

import colliders.BuffArmaCollider;

public class BuffArma extends Buff {
	private ImageIcon imagenBuff = new ImageIcon(this.getClass().getResource("/buffs/ImagenBuff (1).jpg"));
	
	
	public BuffArma(int x, int y) {
		super();
		this.pos.setBounds(x,y,ancho,alto);
		this.pos.setIcon(imagenBuff);
		velocidad=20;
		pos.setIcon(imagenBuff);
		daño=1;
		myCollider= new BuffArmaCollider(daño);
	}
	
	//public void activarEscudo
}
