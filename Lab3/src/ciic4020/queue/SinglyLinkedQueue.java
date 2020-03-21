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
		trailer = new Node();
	}
	@Override
	public void enqueue(E e) {
		Node newNode = new Node(e, null);
		
		if (e == null)
			throw new IllegalArgumentException("Parameter cannot be null");
		/* Elements are added at the rear of the queue */
		if(this.size() == 0) {
			this.header = newNode;
			this.trailer = this.header;
			this.currentSize++;
		}
		else if(this.size() >= 1) {
			this.trailer.setNext(newNode);
			this.trailer = newNode;
			this.currentSize++;
		}
		
	}

	@Override
	public E dequeue() {
		/* Elements are removed from the front of the queue */
		if(this.isEmpty())
			return null;
		Node rmNode = header;
		E result = rmNode.getValue();
		this.header = rmNode.getNext();
		rmNode.clear();
		this.currentSize--;
		return result;
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
		while (!isEmpty())
			dequeue();
	}

	@Override
	public int size() {
		return this.currentSize;
	}

	@SuppressWarnings("unchecked")
	@Override
	public E[] toArray() {
		E[] theArray = (E[]) new Object[this.size()];
		int i = 0;
		for(Node curNode = header; curNode != null; curNode = curNode.getNext()) {
			theArray[i++] = curNode.getValue();
		}
		return theArray;
		
	}

}
