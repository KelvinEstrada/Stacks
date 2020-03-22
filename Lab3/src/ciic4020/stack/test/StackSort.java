package ciic4020.stack.test;
import java.util.Scanner;
import ciic4020.stack.ArrayStack;
import ciic4020.stack.ArrayStackFactory;
import ciic4020.stack.Stack;

public class StackSort {

	public static void main(String[] args) {
		ArrayStackFactory<Integer> factory = new ArrayStackFactory<Integer>();
		Stack<Integer> stack = factory.newInstance();
		int intInput = 0;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter an integer number: ");
		while(true) {
			String input = sc.nextLine();
			if(input.equals("")) {
				break;
			}
			else {
				intInput = Integer.parseInt(input);
				stack.push(intInput);
			}
		}
		Stack<Integer> sortedStack = sortStack(stack);
		printStack(sortedStack);
//		sortStackRecursive(stack);
//		printStack(stack);
	}

	public static Stack<Integer> sortStack(Stack<Integer> stack) {
		Stack<Integer> leftStack = new ArrayStack<Integer>(1);
		Stack<Integer> rightStack = new ArrayStack<Integer>(1);

		/* Fill left stack to begin sorting the elements.*/
		while(!stack.isEmpty() && stack.top() != null) {
			leftStack.push(stack.pop());
		}
		/* The right stack will be used as a temporary stack to sort the elements. */
		while(!leftStack.isEmpty()) {
			/* The first element is popped to assume it is the smallest element. */
			int temp = leftStack.pop();
			/* If the top of the right stack is bigger than the first element popped from the left stack, push the top of the right stack
			 * to the left stack. If not, push the first element popped from the left stack to the right stack. */
			while(!rightStack.isEmpty() && rightStack.top() > temp) {
				leftStack.push(rightStack.pop());
			}
			rightStack.push(temp);
		}
		return rightStack;
	}
	/* This sorting recursive method was added as practice to sort the stack recursively. */
	public static void sortStackRecursive(Stack<Integer> stack) {
		if(!stack.isEmpty()) {
			/* Pop the stack top and save it in a temporary value. */
			int temp = stack.pop();
			/* Call the method without the popped value. */
			sortStackRecursive(stack);
			/* Call the helper method to solve the problem with the stack after removing top element and the temporary element removed from the stack. */
			sortHelper(stack, temp);
		}
	}
	/* This helper method does everything else. Verifies if top of the stack is smaller than temp element. 
	 * If so, push again tp the stack. If not, pop again and repeat. */
	public static void sortHelper(Stack<Integer> stack, int element) {
		if(stack.isEmpty() || stack.top() < element) {
			stack.push(element);
		}
		else {
			int temp = stack.pop();
			sortHelper(stack, element);
			stack.push(temp);
		}
	}
	
	public static void printStack(Stack<Integer> stack) {
		Object[] asArray = stack.toArray();
		for(int i = 0; i < asArray.length; i++) {
			System.out.println(asArray[i]);
		}
	}

}
