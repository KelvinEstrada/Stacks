package ciic4020.queue;

public class CircularDoublyLinkedDeque<E> implements Deque<E>{

	@SuppressWarnings("unused")
	private class Node {
		private E value;
		private Node next, prev;

		public Node(E value, Node next, Node prev) {
			this.value = value;
			this.next = next;
			this.prev = prev;
		}

		public Node(E value) {
			this(value, null, null); // Delegate to other constructor
		}

		public Node() {
			this(null, null, null); // Delegate to other constructor
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

		public Node getPrev() {
			return prev;
		}

		public void setPrev(Node prev) {
			this.prev = prev;
		}

		public void clear() {
			value = null;
			next = prev = null;
		}				
	} // End of Node class

	//private fields
	private int currentSize = 0;
	Node header, trailer;

	public CircularDoublyLinkedDeque() {
		currentSize = 0;
		header = new Node();
		trailer = new Node(null, header, null);
		header.setNext(trailer);
	}

	@Override
	public int size() {
		return this.currentSize;
	}

	@Override
	public boolean isEmpty() {
		return this.size() == 0;
	}

	@Override
	public void clear() {
		while(size() > 0)
			removeFirst();
	}

	@Override
	public E getFirst() {
		return trailer.getValue();
	}

	@Override
	public E getLast() {
		return header.getNext().getValue();
	}

	@Override
	public void addFirst(E element) throws IllegalArgumentException {
		if(element == null) {
			throw new IllegalArgumentException("Parameter cannot be null.");
		}
		if(size() == 0) {
			Node newNode = new Node(element, null, null);
			/*	New node becomes the trailer, as it is the only element in the queue
			 * 
			 */
			trailer = newNode;
			header.setNext(trailer);
			trailer.setNext(header);
			trailer.setPrev(header);
			currentSize++;
		}
		else {
			/*	Insert new node at the front (in this case the trailer of the queue)
			 * 
			 */
			Node newNode = new Node(element, null, null);
			trailer.setNext(newNode);
			newNode.setNext(header);
			newNode.setPrev(trailer);
			trailer = newNode;
			currentSize++;
		}
	}

	@Override
	public void addLast(E element) throws IllegalArgumentException {
		if(element == null) {
			throw new IllegalArgumentException("Parameter cannot be null.");
		}
		if(size() == 0) {
			throw new IllegalArgumentException("You cannot add to the end of the list if size is 0.");
		}
		else {
			Node newNode = new Node(element, null, null);
			newNode.setNext(header.getNext());
			newNode.setPrev(header);
			header.getNext().setPrev(newNode);
			header.setNext(newNode);
			currentSize++;
		}
	}

	@Override
	public E removeFirst() {
		if(size() == 0) {
			return null;
		}
		Node rmNode = trailer;
		E result = rmNode.getValue();
		trailer = rmNode.getPrev();
		trailer.setNext(header);
		rmNode.clear();
		this.currentSize--;
		return result;
	}

	@Override
	public E removeLast() {
		if(size() == 0) {
			return null;
		}
		Node rmNode = header.getNext();
		E result = rmNode.getValue();
		header.setNext(rmNode.getNext());
		rmNode.getNext().setPrev(header);
		rmNode.clear();
		this.currentSize--;
		return result;
	}

	@SuppressWarnings("unchecked")
	@Override
	public E[] toArray() {
		E[] theArray = (E[]) new Object[this.size()];
		/* Store front at the end of the array */
		int i = 0;
		for (Node curNode = trailer; curNode != header; curNode = curNode.getPrev())
			theArray[i++] = curNode.getValue();
		return theArray;
	}

}
