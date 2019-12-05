package org.w00tdevs.absolute.diff;

public class AbsoluteDiff {

	Long limit;
	
	public void printAllSmaller() {
		if(String.valueOf(this.limit).length()<2) {
			System.out.println("-1");
		}else {
			for(int i = 2; i <= String.valueOf(this.limit).length(); i++) {
				printAllSmaller();
			}			
		}
		
	}
	
	private void printAllSmaller(int size, String incompleteNumber) {
		if(size == 0) {
			// the numbers is already completed
			System.out.println(incompleteNumber);
		}else {
			printAllSmaller(size -1, incompleteNumber + "0");
			
			printAllSmaller(size -1, incompleteNumber + Integer.valueOf(incompleteNumber.charAt(incompleteNumber.length() - 1)));
			printAllSmaller(size -1, incompleteNumber + Integer.valueOf(incompleteNumber.charAt(incompleteNumber.length() + 1)));
		}
		
	}
}
