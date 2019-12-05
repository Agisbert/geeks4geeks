package org.w00tdevs.palindrome;
import java.util.Scanner;

/**
 * The Class Palindrome.
 * 
 * Solution for -> https://practice.geeksforgeeks.org/problems/closest-palindrome/0
 * 
 */
public class PalindromeProblem{

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int i = 0; i < t; i++) {
			long value = sc.nextLong();
			System.out.println(PalindromeGenerator.getClosesPal(value));
		}
		sc.close();
	}


	
}



