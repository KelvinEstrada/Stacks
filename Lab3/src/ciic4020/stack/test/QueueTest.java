package ciic4020.stack.test;

import ciic4020.queue.CircularDoublyLinkedDequeFactory;
import ciic4020.queue.Deque;
import ciic4020.queue.DequeFactory;
import ciic4020.queue.Queue;
import ciic4020.queue.QueueFactory;
import ciic4020.queue.SinglyLinkedQueueFactory;

public class QueueTest {

	public static void main(String[] args) {
//		QueueFactory<String> factory = new SinglyLinkedQueueFactory<String>();
//		Queue<String> queue = factory.newInstance();
//		
//		queue.enqueue("Kelvin");
//		queue.enqueue("Jose");
//		queue.enqueue("Juan");
//		queue.enqueue("Ned");
//		System.out.println("------------");
//		System.out.println("Queue size is " + queue.size());
//		System.out.println("------------");
//		printQueue(queue);
//		System.out.println("------------");
//		System.out.println("Dequeuing " + queue.dequeue());
//		System.out.println("Dequeuing " + queue.dequeue());
//		System.out.println("Dequeuing " + queue.dequeue());
//		System.out.println("Dequeuing " + queue.dequeue());
//		System.out.println("------------");
//		queue.enqueue("Alexander");
//		queue.enqueue("Alexander");
//		queue.enqueue("Alexander");
//		printQueue(queue);
//		System.out.println("------------");
//		System.out.println("Queue size is " + queue.size());
//		System.out.println("Clearing queue...");
//		queue.clear();
//		printQueue(queue);
		
		DequeFactory<String> factory1 = new CircularDoublyLinkedDequeFactory<String>();
		Deque<String> deque = factory1.newInstance();
		
		deque.addFirst("Kelvin");
		deque.addFirst("Jil");
		deque.addFirst("Ned");
		deque.addFirst("Juan");
		deque.addFirst("Pedro");
		System.out.println(deque.size());
		printDeque(deque);
		System.out.println("First element is: " + deque.getFirst());
		System.out.println("---------------------------------------");
		deque.addLast("Maria");
		deque.addLast("Jessica");
		printDeque(deque);
		System.out.println("Size is " + deque.size());
		System.out.println("---------------------------------------");
		System.out.println("Removing first element: " + deque.removeFirst());
		System.out.println("Removing first element: " + deque.removeFirst());
		System.out.println("Removing first element: " + deque.removeFirst());
		System.out.println("Removing first element: " + deque.removeFirst());
		deque.addFirst("Jil");
		deque.addFirst("Ned");
		deque.addFirst("Juan");
		deque.addFirst("Pedro");
		printDeque(deque);
		System.out.println("---------------------------------------");
		deque.clear();
		printDeque(deque);
		
	}
	
	public static void printQueue(Queue<String> queue) {
		Object[] arr = queue.toArray();
		for(int i = 0; i < arr.length; i++) {
			System.out.println((String)arr[i]);
		}
	}
	
	public static void printDeque(Deque<String> deque) {
		Object[] arr = deque.toArray();
		for(int i = 0; i < arr.length; i++) {
			System.out.println((String)arr[i]);
		}
	}

}
