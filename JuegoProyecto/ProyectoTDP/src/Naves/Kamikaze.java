package Naves;

import javax.swing.ImageIcon;

import inteligencias.IKamikazeAleatorio;

public class Kamikaze extends Enemigo {
	
	private ImageIcon foto = new ImageIcon(this.getClass().getResource("/Naves/enemigo.gif"));
	
	public Kamikaze() {
		super();
		pos.setBounds(50,50,200,144);
		pos.setVisible(true);
		pos.setIcon(foto);
		IA= new IKamikazeAleatorio();
		
	}
	public void mover(int x) {
		IA.mover(pos);
	}
	
	public void morir() {
		this.pos.setVisible(false);
		this.pos.setIcon(null);
	}
}
