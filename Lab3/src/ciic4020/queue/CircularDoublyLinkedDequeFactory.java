package ciic4020.queue;

public class CircularDoublyLinkedDequeFactory<E> implements DequeFactory<E> {

	@Override
	public Deque<E> newInstance() {
		return new CircularDoublyLinkedDeque<E>();
	}

}