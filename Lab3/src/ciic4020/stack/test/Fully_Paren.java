package ciic4020.stack.test;

import java.util.Scanner;

import ciic4020.stack.LinkedListStackFactory;
import ciic4020.stack.Stack;

public class Fully_Paren {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
	}


	public static boolean isBalanced(String expression) {
		LinkedListStackFactory<Character> factoryStack = new LinkedListStackFactory<Character>();
		Stack<Character> operands = factoryStack.newInstance();
		Stack<Character> operators = factoryStack.newInstance();
		Stack<Character> parenthesis = factoryStack.newInstance();

		for(int i = 0; i < expression.length(); i++) {
			if(!Character.isLetter(expression.charAt(i))) {
				if(Character.isDigit(expression.charAt(i))) {
					operands.push(expression.charAt(i));
				}
				else if(expression.charAt(i) == '[' || expression.charAt(i) == '(' || expression.charAt(i) == '{') {
					parenthesis.push(expression.charAt(i));
				}
			}
			else if(Character.isLetter(expression.charAt(i))) {
				operators.push(expression.charAt(i));
			}
		}
//		for(int i = 0; i < expression.length(); i++) {
//			if() {
//				
//				
//			}
//		}
		return true;
	}

}
