package ciic4020.stack.test;
import java.util.Scanner;
import ciic4020.stack.LinkedListStack;
import ciic4020.stack.Stack;

public class Fully_Paren {

	public static Integer[] VARIABLEVALUES = new Integer[26];

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter an expression: ");
		while(true) {
			String input = scanner.nextLine();
			if(input.isEmpty()) {
				break;
			}
			if(Character.isAlphabetic(input.charAt(0)) && input.charAt(1) == '=') {
				VARIABLEVALUES[((int)input.charAt(0)) - 65] = Integer.parseInt(input.substring(2));
				System.out.println(VARIABLEVALUES[((int)input.charAt(0)) - 65]);
			}
			else if(!isBalanced(input)) {
				System.out.println(input + " " + "is invalid");
			}
			else {
				evaluate(input);
			}
		}
		for(int i = 0; i < VARIABLEVALUES.length; i++) {
			if(VARIABLEVALUES[i] != null) {
				Character value = (char) (i+65);
				System.out.println(value + "\t" + VARIABLEVALUES[i]);
			}
		}
	}

	/*	Print method for testing purposes
	 * 
	 */
	private static void printStack(Stack<Integer> stack) {
		Object[] s = stack.toArray();
		for(int i = 0; i < s.length; i++) {
			System.out.println(s[i]);
		}
	}
	/*	Verifies if expression has balanced parenthesis
	 * 
	 */
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
	/*	After expression is verified to be balanced, this methods evaluates the expression
	 * 
	 */
	public static Integer[] evaluate(String in) {
		Stack<Integer> operands = new LinkedListStack<Integer>();
		Stack<Character> operators = new LinkedListStack<Character>();
		Stack<Character> parenthesis = new LinkedListStack<Character>();
		Stack<Integer> results = new LinkedListStack<Integer>();

		for(int i = 0; i < in.length(); i++) {
			if(in.charAt(i) == '(' || in.charAt(i) == '['|| in.charAt(i) == '{') {
				parenthesis.push(in.charAt(i));
			}
			else if(in.charAt(i) == '+' || in.charAt(i) == '-' || in.charAt(i) == '*' || in.charAt(i) == '/') {
				operators.push(in.charAt(i));
			}
			else if(Character.isLetter(in.charAt(i)) && i != 0) {
				int val = VARIABLEVALUES[(int)in.charAt(i) - 65];
				operands.push(val);
			}
		}
		for(int i = 0; i < in.length(); i++) {
			if(in.charAt(i) == ')' || in.charAt(i) == ']' || in.charAt(i) == '}') {
				if(operands.size() >= 2 || !operators.isEmpty()){
					int operand1 = operands.pop();
					int operand2 = operands.pop();
					Character operator = operators.pop();
					if(operator == '+') {
						int res = operand1 + operand2;
						results.push(res);
						operands.push(res);
						/*	Since the condition of operation is satisfied, the expression is valid
						 * 	and we can assume that the character at position 0 will hold the value of the expression.
						 * 	Then we change its value in the VARIABLES VALUES array.
						 */
						VARIABLEVALUES[(int)in.charAt(0) - 65] = results.pop();
					}
					if(operator == '-') {
						int res = operand2 - operand1;
						results.push(res);
						operands.push(res);
						VARIABLEVALUES[(int)in.charAt(0) - 65] = results.pop();
					}
					if(operator == '*') {
						int res = operand1 * operand2;
						results.push(res);
						operands.push(res);
						VARIABLEVALUES[(int)in.charAt(0) - 65] = results.pop();
					}
					if(operator == '/') {
						int res = operand1 / operand2;
						results.push(res);
						operands.push(res);
						VARIABLEVALUES[(int)in.charAt(0) - 65] = results.pop();
					}
				}
			}
		}
		return VARIABLEVALUES;
	}
}

