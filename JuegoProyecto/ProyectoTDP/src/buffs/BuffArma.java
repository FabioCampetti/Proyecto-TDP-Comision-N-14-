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
		velocidad=20;
		pos.setIcon(imagenBuff);
<<<<<<< HEAD
		timeLeft=25;
		myCollider= new BuffArmaCollider();
=======
		da�o=1;
		myCollider= new BuffArmaCollider(da�o);
>>>>>>> 4472266eecc84e77bc7efb68bf89943f18641dfc
	}


	public void terminarBuff(Mapa m) {
		m.getJugador().cambiarArma(new ArmaJugadorEstandar(m.getJugador()));
		this.morir();
	}
	

}
