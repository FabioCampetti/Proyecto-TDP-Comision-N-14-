package Naves;

public class Memento<E> {
	private E state;
	public Memento(E state) {
		this.state=state;
	}
	public E getState() {
		return state;
	}
}
