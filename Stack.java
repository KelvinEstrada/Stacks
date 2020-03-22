
public interface Stack<E> {

	public int size();
	public E top();
	public boolean isEmpty();
	public void clear();
	public E pop();
	public void push(E e);
	public Stack<E> reverse();
	public Object[] toArray();
	
}
