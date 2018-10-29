package inteligencias;

import javax.swing.JLabel;

import disparos.DisparoSuperMisil;
import naves.Entidad;

public class IDisparoSuperMisil extends Inteligencia {
	private float aceleracion = 1;

	@Override

	public void mover(Entidad e) {
		
			JLabel pos = e.getPosicion();
			int velocidad = (int) (aceleracion * e.getVelocidad());
			pos.setLocation(pos.getX(), pos.getY() - velocidad);
			if (pos.getY() + DisparoSuperMisil.alto < 0)
				e.morir();
			pos.setBounds(pos.getX(), pos.getY(), pos.getWidth(), pos.getHeight() + velocidad);
			aceleracion *= 1.1;
	
	}

}
