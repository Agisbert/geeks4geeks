package org.w00tdevs.palindrome;

import static org.junit.Assert.assertNull;

import org.junit.Assert;
import org.junit.Test;
import org.w00tdevs.palindrome.TwoPrimeProblem.PrimePair;

/**
 * The Class PalindromeGeneratorTests.
 */
public class TwoPrimeProblemTest{
	
	@Test
	public void printSumOf55() {
		PrimePair printSumOfPrimes = TwoPrimeProblem.getSumPair(55L);
		Assert.assertEquals(2L, printSumOfPrimes.prime1.longValue());
		Assert.assertEquals(53L, printSumOfPrimes.prime2.longValue());
	}
	
	@Test
	public void printSumOf9990() {
		PrimePair printSumOfPrimes = TwoPrimeProblem.getSumPair(9990L);
		Assert.assertEquals(17L, printSumOfPrimes.prime1.longValue());
		Assert.assertEquals(9973L, printSumOfPrimes.prime2.longValue());
	}

	@Test
	public void printSumOf3() {
		PrimePair printSumOfPrimes = TwoPrimeProblem.getSumPair(3L);
		assertNull(printSumOfPrimes);
	}
	
	@Test
	public void printSumOf4() {
		PrimePair printSumOfPrimes = TwoPrimeProblem.getSumPair(4L);
		Assert.assertEquals(2L, printSumOfPrimes.prime1.longValue());
		Assert.assertEquals(2L, printSumOfPrimes.prime2.longValue());
	}
	
}




