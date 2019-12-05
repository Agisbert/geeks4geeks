package org.w00tdevs.parentheses;
import java.util.Scanner;
import java.util.Stack;

/**
 * 
 * Solution for -> https://practice.geeksforgeeks.org/problems/longest-valid-parentheses/0
 * 
 * Input:
 * 2
 * ((()
 * )()())
 *
 * Output:
 * 2
 * 4
 * 
 */
public class ParenthesesProblem {


	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int i = 0; i < t; i++) {
			String parentheses = sc.next();
			System.out.println(getLongOfValidParentheses(parentheses));
		}
		sc.close();
	}

	public static long getLongOfValidParentheses(String parentheses) {
		Stack<Long> stack = new Stack<Long>();
		stack.push(-1L);
		long position = 0;
		long max = 0;
		for (char c: parentheses.toCharArray()) {
			if(c == '(') {
				stack.push(position);
			} else {
				stack.pop();
				if(!stack.empty()) {
					max = Math.max(position - stack.peek(), max);
				} else {
					stack.push(position);
				}
			}
			position++;
		}

		return max; 
	}
	
}
