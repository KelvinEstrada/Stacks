package ciic4020.stack.test;
import java.util.Scanner;

import ciic4020.queue.Queue;
import ciic4020.queue.SinglyLinkedQueue;
import ciic4020.stack.LinkedListStack;
import ciic4020.stack.Stack;

public class Fully_Paren {

	public static Integer[] VARIABLEVALUES = new Integer[26];

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Queue<String> invalids = new SinglyLinkedQueue<String>();
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter an expression: ");
		while(true) {
			String input = scanner.nextLine();
			if(input.isEmpty()) {
				break;
			}
			/* When a character is value is entered, it is saved in the variable values array */
			/* We get the letter's ascii code and substract 65 (A's ascii code) to get the index position within the array
			 * where the variable value will be placed. Example: L's ascii code is 76, 76 - 65 = 11, hence L is the letter 12 in the alphabet
			 * and will be stored in that position-1 (because arrays are 0 based) within the array. */
			if(Character.isAlphabetic(input.charAt(0)) && input.charAt(1) == '=') {
				VARIABLEVALUES[((int)input.charAt(0)) - 65] = Integer.parseInt(input.substring(2));
			}
			/* We will be storing the invalid expressions in a queue to print them out after the user is done inputting data.*/
			else if(!isBalanced(input)) {
				invalids.enqueue(input);
			}
			else {
				evaluate(input);
			}
		}
		while(!invalids.isEmpty()) {
			System.out.println(invalids.dequeue() + " is invalid");
		}
		System.out.println("");
		System.out.println("Results:");
		System.out.println("Variable" + "\t" + "Value");
		for(int i = 0; i < VARIABLEVALUES.length; i++) {
			if(VARIABLEVALUES[i] != null) {
				Character value = (char) (i+65);
				System.out.println(value + "\t" + "\t" + VARIABLEVALUES[i]);
			}
		}
	}

	/*	Print method for testing purposes
	 * 
	 */
//	private static void printStack(Stack<Integer> stack) {
//		Object[] s = stack.toArray();
//		for(int i = 0; i < s.length; i++) {
//			System.out.println(s[i]);
//		}
//	}
	/*	Verifies if expression has balanced parenthesis
	 * 
	 */
	public static boolean isBalanced(String input) {
		Stack<Character> stack = new LinkedListStack<Character>();
		/* Push all opening parenthesis to the stack. */
		for(int i = 0; i < input.length(); i++) {
			if(input.charAt(i) == '(' || input.charAt(i) == '[' || input.charAt(i) == '{') {
				stack.push(input.charAt(i));
			}
		}
		/* Loop again through the string and when an opening parenthesis is found, verify against the parenthesis in the stack. If it matches
		 * pop the parenthesis stack and keep checking. */
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
		/* If the stack is empty, it means that all parenthesis have a match, thus the expression is balanced.*/
		return stack.isEmpty();
	}
	/*	After expression is verified to be balanced, this methods evaluates the expression. */
	public static Integer[] evaluate(String in) {
		Stack<Integer> operands = new LinkedListStack<Integer>();
		Stack<Character> operators = new LinkedListStack<Character>();
		Stack<Character> parenthesis = new LinkedListStack<Character>();
		Stack<Integer> results = new LinkedListStack<Integer>();
		for(int i = 0; i < in.length(); i++) {
			/* When an opening parenthesis is found, push it into the parenthesis stack. */
			if(in.charAt(i) == '(' || in.charAt(i) == '['|| in.charAt(i) == '{') {
				parenthesis.push(in.charAt(i));
			}
			/* When an operator is found, push it into the operators stack. */
			else if(in.charAt(i) == '+' || in.charAt(i) == '-' || in.charAt(i) == '*' || in.charAt(i) == '/') {
				operators.push(in.charAt(i));
			}
			/* When an operand is found, push it into the operands stack. */
			else if(Character.isLetter(in.charAt(i)) && i != 0) {
				int val = VARIABLEVALUES[(int)in.charAt(i) - 65];
				operands.push(val);
			}
			/* if an opening parenthesis is found, evaluate the subsexpressions inside of it by popping the operands stacks twice
			 * to get the two operands and popping the operators stack once to know which operation will be perfomed. */
			else if(in.charAt(i) == ')' || in.charAt(i) == ']' || in.charAt(i) == '}') {
				if(operands.size() >= 2 || !operators.isEmpty()){
					int operand1 = operands.pop();
					int operand2 = operands.pop();
					Character operator = operators.pop();
					if(operator == '+') {
						int res = operand1 + operand2;
						results.push(res);
						operands.push(res);
						parenthesis.pop();
						/*	Since the condition of operation is satisfied, the expression is valid
						 * 	and we can assume that the character at position 0 will hold the value of the expression.
						 * 	Then we change its value in the VARIABLES VALUES array.
						 */
						VARIABLEVALUES[(int)in.charAt(0) - 65] = res;
					}
					if(operator == '-') {
						int res = 0;
						if(operators.size() == 1) {		//this is done to avoid doing the operation inverse
							if(operand2 > operand1) {
								res = operand2 - operand1;
							}
							else {res = operand1 - operand2;}
						}
						else {
							res = operand2 - operand1;
						}
						results.push(res);
						operands.push(res);
						parenthesis.pop();
						VARIABLEVALUES[(int)in.charAt(0) - 65] = res;
					}
					if(operator == '*') {
						int res = operand1 * operand2;
						results.push(res);
						operands.push(res);
						VARIABLEVALUES[(int)in.charAt(0) - 65] = res;
					}
					if(operator == '/') {
						int res = operand2 / operand1;
						results.push(res);
						operands.push(res);
						parenthesis.pop();
						VARIABLEVALUES[(int)in.charAt(0) - 65] = res;
					}
				}
			}
		}
		return VARIABLEVALUES;
	}
}

