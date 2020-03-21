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

		while(!stack.isEmpty() && stack.top() != null) {
			leftStack.push(stack.pop());	//leftStack is filled
		}
		//right stack will be a 'temporary stack'
		while(!leftStack.isEmpty()) {
			int temp = leftStack.pop();
			while(!rightStack.isEmpty() && rightStack.top() > temp) {
				leftStack.push(rightStack.pop());
			}
			rightStack.push(temp);
		}
		return rightStack;
	}
	
	public static void sortStackRecursive(Stack<Integer> stack) {
		if(!stack.isEmpty()) {
			int temp = stack.pop();
			sortStackRecursive(stack);
			sortHelper(stack, temp);
		}
	}
	
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
