package inteligencias;

import java.awt.Point;

import javax.swing.JLabel;

public class MovParametrico {
	public static Point dondeMoverElipse(JLabel pos, float t) {
		Point a= new Point();
		a.x=(int) (5*Math.cos(t)) +pos.getX();
		a.y=(int) (5*Math.sin(t)) +pos.getY();
		return a;
	}
	
	public static Point dondeMoverLemnis(JLabel pos, float t) {
		Point a= new Point();
		a.x=(int) ((15*Math.sin(t)/(Math.pow(Math.cos(t),2)+1))) +pos.getX();
		a.y=(int) (((15*Math.cos(t)*Math.sin(t))/(Math.pow(Math.cos(t),2)+1)))+pos.getY();
		return a;
	}
	
	public static Point dondeMoverDib(JLabel pos, float t) {
		Point a= new Point();
		a.x=(int) (10*Math.sin(2*t)) +pos.getX();
		a.y=(int) (10*Math.cos(3*t)) +pos.getY();
		return a;
	} 
}
