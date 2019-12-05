package org.w00tdevs.palindrome;


/**
 * The Class PalindromeGenerator.
 */
public class PalindromeGenerator{

	/**
	 * Given a number, gets the lowest palindrome without modifying.
	 * 
	 * 145 -> 141
	 *
	 * @param number
	 *            the number
	 * @return the sim pal
	 */
	public static Long getSimilarPalindrome(Long number) {
		String value = number.toString();
		if(value.length() == 1) {
			return number - 1;
		}
		String halfPal = value.substring(0, (value.length()/2) + (value.length() % 2));
		String pal = halfPal + new StringBuilder(halfPal.substring(0, halfPal.length() - (value.length() % 2))).reverse().toString();
		return Long.valueOf(pal);
	}

	/**
	 * Given a number, gets the lower closest palindrome.
	 * 
	 * 145 -> 131
	 *
	 * @param number the number
	 * @return the smallest pal
	 */
	public static Long getLowerPalindrome(Long number){
		String value = number.toString();
		String halfPal = value.substring(0, (value.length()/2) + (value.length() % 2));
		String lowerHalfPal = String.valueOf(Integer.valueOf(halfPal) - 1);
		String pal = null;
		if(lowerHalfPal.length() < halfPal.length()){
			if(value.length() % 2 > 0) {
				pal = lowerHalfPal + new StringBuilder(lowerHalfPal.substring(0, lowerHalfPal.length())).reverse().toString();		
			}else {
				pal = lowerHalfPal + "9" + new StringBuilder(lowerHalfPal.substring(0, lowerHalfPal.length())).reverse().toString();	
			}
		} else {				
			pal = lowerHalfPal + new StringBuilder(lowerHalfPal.substring(0, lowerHalfPal.length() - (value.length() % 2))).reverse().toString();
		}
		return Long.valueOf(pal);

	}

	/**
	 * Given a number, gets the bigger closest palindrome
	 * 
	 * 145 -> 151.
	 *
	 * @param number
	 *            the number
	 * @return the biggest pal
	 */
	public static Long getHigherPalindrome(Long number){
		String value = number.toString();
		String halfPal = value.substring(0, (value.length()/2)+ (value.length() % 2));
		String upperHalfPal = String.valueOf(Integer.valueOf(halfPal) + 1);
		String pal = null;
		if(upperHalfPal.length() > halfPal.length()){
			pal = upperHalfPal + new StringBuilder(upperHalfPal.substring(0, upperHalfPal.length() - 1 - (value.length() % 2))).reverse().toString();		
		} else {				
			pal = upperHalfPal + new StringBuilder(upperHalfPal.substring(0, upperHalfPal.length() - (value.length() % 2))).reverse().toString();
		}
		return Long.valueOf(pal);
	}


	/**
	 * Gets the closes pal improved.
	 *
	 * @param number the number
	 * @return the closes pal improved
	 */
	public static Long getClosesPal(Long number){
		if(number.toString().length() == 1) {
			return (long) number -1;
		}
		Long lowerPal = getLowerPalindrome(number);
		Long higherPal = getHigherPalindrome(number);
		Long simPal = getSimilarPalindrome(number);

		Long tempPal = lowerPal;
		if(!simPal.equals(number) && Math.abs(number - lowerPal) > Math.abs(number - simPal)){
			tempPal = simPal;
			if(Math.abs(number - simPal) > Math.abs(number - higherPal)){
				tempPal = higherPal;
			}
		}else  if(Math.abs(number - lowerPal) > Math.abs(number - higherPal)){
			tempPal = higherPal;
		}

		return tempPal;
	}
}



