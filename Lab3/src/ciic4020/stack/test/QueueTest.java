package ciic4020.stack.test;

import ciic4020.queue.Queue;
import ciic4020.queue.QueueFactory;
import ciic4020.queue.SinglyLinkedQueue;
import ciic4020.queue.SinglyLinkedQueueFactory;

public class QueueTest {

	public static void main(String[] args) {
		QueueFactory<String> factory = new SinglyLinkedQueueFactory<String>();
		Queue<String> queue = factory.newInstance();
		
		
		queue.enqueue("Kelvin");
		queue.enqueue("Kelvin");
		queue.enqueue("Kelvin");
		queue.enqueue("Kelvin");
		
		System.out.println(queue.front());
	}

}
