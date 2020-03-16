package ciic4020.queue;

public class SinglyLinkedQueueFactory<E> implements QueueFactory<E> {

	@Override
	public Queue<E> newInstance() {
		return new SinglyLinkedQueue<E>();
	}

}