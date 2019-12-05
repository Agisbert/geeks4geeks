package org.w00tdevs.palindrome;

import org.junit.Assert;
import org.junit.Test;

/**
 * The Class PalindromeGeneratorTests.
 */
public class PalindromeGeneratorTests{
	
	@Test
	public void getClosesPalTest() {
		Long pal = Long.valueOf(122);
		Long closestPal = PalindromeGenerator.getClosesPal(pal);
		Assert.assertTrue(Long.valueOf(121).equals(closestPal));
	}
	
	@Test
	public void getClosesPalTestTrickyLow() {
		Long pal = Long.valueOf(100);
		Long closestPal = PalindromeGenerator.getClosesPal(pal);
		Assert.assertTrue(Long.valueOf(99).equals(closestPal));
	}
	
	@Test
	public void getClosesPalTestTrickyHigh() {
		Long pal = Long.valueOf(999);
		Long closestPal = PalindromeGenerator.getClosesPal(pal);
		Assert.assertTrue(Long.valueOf(1001).equals(closestPal));
	}
	
	@Test
	public void getLowerPal() {
		Long pal = 122L;
		Long lowerPal = PalindromeGenerator.getLowerPalindrome(pal);
		Assert.assertTrue(Long.valueOf(111).equals(lowerPal));
	}
	
	@Test
	public void getHigherPal() {
		Long pal = 122L;
		Long lowerPal = PalindromeGenerator.getHigherPalindrome(pal);
		Assert.assertTrue(Long.valueOf(131).equals(lowerPal));
	}
	
	@Test
	public void getSimilarPal() {
		Long pal = 122L;
		Long lowerPal = PalindromeGenerator.getSimilarPalindrome(pal);
		Assert.assertTrue(Long.valueOf(121).equals(lowerPal));
	}
	
	
}



