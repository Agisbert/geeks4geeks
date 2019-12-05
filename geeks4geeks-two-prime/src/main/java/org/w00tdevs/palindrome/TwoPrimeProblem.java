package org.w00tdevs.palindrome;
import java.util.ArrayList;
import java.util.Scanner;

// Solution for -> https://practice.geeksforgeeks.org/problems/return-two-prime-numbers/0
public class TwoPrimeProblem{


	private static ArrayList<Long> primes = new ArrayList<Long>(); 
	
	public static class PrimePair{
		Long prime1;
		Long prime2;
		
		public PrimePair(Long prime1, Long prime2) {
			super();
			this.prime1 = prime1;
			this.prime2 = prime2;
		}

		@Override
		public String toString() {
			return prime1 + " " + prime2;
		}
		
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int i = 0; i < t; i++) {
			Long value = sc.nextLong();
			PrimePair pair = getSumPair(value);
			if (pair != null) {
				System.out.println(pair);
			} 
		}
		sc.close();
	}

	public static PrimePair getSumPair(long value) {
		if(primes.size() == 0) {
			// init to make my life easier
			primes.add(2L);
			primes.add(3L);
		}
		while(value > primes.get(primes.size() - 1)) {
			Long lastPrime = primes.get(primes.size() - 1);
			while(!isPrime(lastPrime+=2)) {
			}
			primes.add(lastPrime);
			
		}

		for(int i = 0; i < primes.size(); i++) {
			Long rest = value - primes.get(i);
			if(primes.contains(rest)) {
				return new PrimePair(primes.get(i), rest);
			}
		}
		return null;
	}


	private static boolean isPrime(Long possiblePrime) {
		for(int i = 0; (i < primes.size() && (primes.get(i)*primes.get(i) <= possiblePrime)); i++) {
			if(possiblePrime % primes.get(i) == 0) {
				return false;
			}
		}
		return true;
	}
	
	

}



