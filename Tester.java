
public class Tester {

	public static void main(String[] args) {
		
		Stack<String> stack = new ArrayStack<String>(2);
		
		stack.push("Kelvin");
		stack.push("Carolina");
		stack.push("Mike");
		printStack(stack);	
		System.out.println("Top of the stack is " + stack.top());
		System.out.println("Popped " + stack.pop());
		printStack(stack);	
		stack.push("Jazar");
		System.out.println("Pushed...");
		printStack(stack);
		System.out.println("Stack size: " + stack.size());
		System.out.println("Reversing stack...");
		printStack(stack.reverse());
		
	}

	private static void printStack(Stack<String> stack) {
		Object[] asArray = stack.toArray();
		for(int i = asArray.length - 1; i >= 0; i--) {
			System.out.println(asArray[i]);
		}
	}
	
}
