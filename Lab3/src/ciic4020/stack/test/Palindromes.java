package ciic4020.stack.test;
import java.util.Scanner;

import ciic4020.queue.DoublyLinkedQueueFactory;
import ciic4020.queue.Queue;
import ciic4020.stack.ArrayStackFactory;
import ciic4020.stack.LinkedListStackFactory;
import ciic4020.stack.Stack;
import ciic4020.stack.StackFactory;

public class Palindromes {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		System.out.println("Enter a string: ");
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();

		if(isPalindrome(input)) {
			System.out.println("Palindrome");
		}
		else {
			System.out.println("Not a palindrome");
		}

	}
	/*	Determine if string is a palindrome using stacks only
	 * 
	 */
	public static boolean isPalindromeStack(String input) {
		LinkedListStackFactory<Character> factory = new LinkedListStackFactory<Character>();
		Stack<Character> stack = factory.newInstance();
		String allTogether = "";
		for(int i = 0; i < input.length(); i++) {
			if(Character.isLetter(input.charAt(i))) {
				allTogether += input.charAt(i);
			}
		}
		allTogether = allTogether.toLowerCase();
		for(int i = 0; i < allTogether.length(); i++) {
			stack.push(allTogether.charAt(i));
		}
		for(int i = 0; i < allTogether.length(); i++) {
			if(!stack.pop().equals(allTogether.charAt(i))) {
				return false;
			}
		}
		return true;
	}
	/*	Determines if a string is a palindrome using a combination of a stack and a queue
	 * 
	 */
	public static boolean isPalindrome(String input) {
		LinkedListStackFactory<Character> factoryStack = new LinkedListStackFactory<Character>();
		Stack<Character> stack = factoryStack.newInstance();
		DoublyLinkedQueueFactory<Character> factoryQueue = new DoublyLinkedQueueFactory<Character>();
		Queue<Character> queue = factoryQueue.newInstance();
		
		String lowerCase = "";
		for(int i = 0; i < input.length(); i++) {
			if(Character.isLetter(input.charAt(i))) {
				lowerCase += input.charAt(i);
			}
		}
		lowerCase = lowerCase.toLowerCase();
		for(int i = 0; i < lowerCase.length(); i++) {
			stack.push(lowerCase.charAt(i));
			queue.enqueue(lowerCase.charAt(i));
		}
		for(int i = 0; i < lowerCase.length(); i++) {
			if(!stack.pop().equals(queue.dequeue())) {
				return false;
			}
		}
		return true;
	}

}