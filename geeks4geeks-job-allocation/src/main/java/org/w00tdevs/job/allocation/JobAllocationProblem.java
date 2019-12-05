package org.w00tdevs.job.allocation;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;


/**
 * @author agisbert
 *
 * Solution for -> https://practice.geeksforgeeks.org/problems/assignment-problem/0
 * 
 */
public class JobAllocationProblem{


	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int i = 0; i < t; i++) {
			int employees = sc.nextInt();
			Integer[][] jobs = new Integer[employees][employees];
			for(int j = 0; j < employees*employees; j++) {
				jobs[j/employees][j%employees] = sc.nextInt();
			}
			HungarianMethod jobsAlloc = new HungarianMethodImpl(jobs);
			System.out.println(jobsAlloc.getMinimunAssigment());


		}
		sc.close();
	}
}
