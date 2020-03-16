package ciic4020.queue;

public class SinglyLinkedQueue<E> implements Queue<E> {
	@SuppressWarnings("unused")
	private class Node {
		private E value;
		private Node next;

		public Node(E value, Node next) {
			this.value = value;
			this.next = next;
		}

		public Node(E value) {
			this(value, null); // Delegate to other constructor
		}
		
		public Node() {
			this(null, null); // Delegate to other constructor
		}
		
		public E getValue() {
			return value;
		}

		public void setValue(E value) {
			this.value = value;
		}

		public Node getNext() {
			return next;
		}

		public void setNext(Node next) {
			this.next = next;
		}

		public void clear() {
			value = null;
			next = null;
		}				
	} // End of Node class

	// private fields
	int currentSize;
	Node header, trailer;
	public SinglyLinkedQueue() {
		currentSize = 0;
		header = new Node();
		trailer = new Node(null, header);
	}
	@Override
	public void enqueue(E e) {
		// TODO Auto-generated method stub
		Node newNode = new Node(null, null);
		if (e == null)
			throw new IllegalArgumentException("Parameter cannot be null");
		/* Elements are added at the rear of the queue */
		if(this.size() == 0) {
			header.setValue(e);
		}
		else {
			newNode.setValue(e);
			newNode.setNext(header);
		}
		
	}

	@Override
	public E dequeue() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E front() {
		if (isEmpty())
			return null;
		return header.getValue();
	}

	@Override
	public boolean isEmpty() {
		return this.size() == 0;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub

	}

	@Override
	public int size() {
		return this.currentSize;
	}

	@Override
	public E[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

}
