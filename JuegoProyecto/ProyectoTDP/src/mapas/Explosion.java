package mapas;

import java.awt.Rectangle;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Explosion {
	private int timeLeft;
	private ImageIcon imagenExplosion=new ImageIcon(this.getClass().getResource("/Mapas/Explosion.gif"));;
	private JLabel labelExplosion;
	
	public Explosion (int x, int y) {
		labelExplosion=new JLabel();
		labelExplosion.setBounds(x, y, imagenExplosion.getIconWidth(),imagenExplosion.getIconHeight());
		timeLeft=50;
		labelExplosion.setIcon(imagenExplosion);
		
	}
	
	public boolean isDone() {
		return (timeLeft<=0);
	}
	
	public JLabel getLabel() {
		return labelExplosion;
	}
	
	public void tick() {
		timeLeft--;
	}
}
