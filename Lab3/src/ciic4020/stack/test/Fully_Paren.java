package ciic4020.stack.test;
import java.util.Scanner;
import ciic4020.stack.LinkedListStack;
import ciic4020.stack.Stack;

public class Fully_Paren {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Stack<Integer> operands = new LinkedListStack<Integer>();
		Stack<Character> operators = new LinkedListStack<Character>();
		Stack<Character> parenthesis = new LinkedListStack<Character>();
		Stack<Integer> results = new LinkedListStack<Integer>();
		while(true) {
			System.out.println("Enter an expression: ");
			String input = scanner.nextLine();
			if(input.isEmpty()) {
				System.out.println("No expression typed. Closing...");
				break;
			}
			else if(!isBalanced(input)) {
				System.out.println(input + " " + "is invalid.");
				break;
			}
			for(int i = 0; i < input.length(); i++) {
				if(Character.isDigit(input.charAt(i))) {
					String number = "";
					while(Character.isDigit(input.charAt(i))) {
						number += input.charAt(i);
						i++;
					}
					operands.push(Integer.parseInt(number));
					number = "";
				}
				else if(input.charAt(i) == '+') {
					operators.push(input.charAt(i));
				}
				else if(input.charAt(i) == '-') {
					operators.push(input.charAt(i));
				}
				else if(input.charAt(i) == '*') {
					operators.push(input.charAt(i));
				}
				else if(input.charAt(i) == '/') {
					operators.push(input.charAt(i));
				}
				else if(input.charAt(i) == '(' || input.charAt(i) == '[' || input.charAt(i) == '{') {
					parenthesis.push(input.charAt(i));
				}
			}
			while(parenthesis.top() == '(' || parenthesis.top() == '[' || parenthesis.top() == '{') {
				results.push(operands.pop());
				results.push(operands.pop());
				Character op = operators.pop();
				if(op == '+') {
					int result = results.pop() + results.pop();
					results.push(result);
					parenthesis.pop();
				}
				if(op == '-') {
					int result = results.pop() - results.pop();
					results.push(result);
					parenthesis.pop();
				}
				if(op == '*') {
					int result = results.pop() * results.pop();
					results.push(result);
					parenthesis.pop();
				}
				if(op == '/') {
					int result = results.pop() / results.pop();
					results.push(result);
					parenthesis.pop();
				}
			}
		}
		printStack(operands);
	}
	private static void printStack(Stack<Integer> parenthesis) {
		Object[] s = parenthesis.toArray();
		for(int i = 0; i < s.length; i++) {
			System.out.println(s[i]);
		}
	}
	public static boolean isBalanced(String input) {
		Stack<Character> stack = new LinkedListStack<Character>();
		for(int i = 0; i < input.length(); i++) {
			if(input.charAt(i) == '(' || input.charAt(i) == '[' || input.charAt(i) == '{') {
				stack.push(input.charAt(i));
			}
		}
		for(int i = 0; i < input.length(); i++) {
			if(stack.isEmpty()) {
				return false;
			}
			if(stack.top() == '(' && input.charAt(i) == ')') {
				stack.pop();
			}
			else if(stack.top() == '[' && input.charAt(i) == ']') {
				stack.pop();
			}
			else if(stack.top() == '{' && input.charAt(i) == '}') {
				stack.pop();
			}
		}
		return stack.isEmpty();
	}
}

