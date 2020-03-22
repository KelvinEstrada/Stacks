
public class ArrayStack<E> implements Stack<E> {
	//private fields
	
	private int top;
	private E[] elements;
	
	@SuppressWarnings("unchecked")
	public ArrayStack(int initialCapacity) {
		if(initialCapacity < 1) {
			throw new IllegalArgumentException();
		}
		top = 0;
		elements = (E[]) new Object[initialCapacity];
	}
	@Override
	public int size() {
		return top;
	}

	@Override
	public E top() {
		return elements[top - 1];
	}

	@Override
	public boolean isEmpty() {
		return size() == 0;
	}

	@Override
	public void clear() {
		while(!this.isEmpty())
			pop();
	}

	@Override
	public E pop() {
		if(this.isEmpty())
			return null;
		E result = elements[top - 1];
		top--;
		return result;
	}

	@Override
	public void push(E e) {
		if(this.size() == elements.length)
			reAllocate();
		elements[top] = e;
		top++;
	}

	@SuppressWarnings("unchecked")
	private void reAllocate() {
		Object[] newArray = new Object[this.size() * 2];
		for(int i = 0; i < this.size(); i++) {
			newArray[i] = elements[i];
		}
		this.elements = (E[]) newArray;
		
	}
	@Override
	public Stack<E> reverse() {
		Stack<E> newStack = new ArrayStack<E>(this.size());
		while(!this.isEmpty())
			newStack.push(this.pop());
		
		return newStack;
	}
	@Override
	public Object[] toArray() {
		Object[] asArray = new Object[this.size()];
		for(int i = 0; i < this.size(); i++) {
			asArray[i] = elements[i];
		}
		return asArray;
	}

}
;