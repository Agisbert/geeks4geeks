package org.w00tdevs.job.allocation;

import java.util.stream.IntStream;

/**
 * @author agisbert
 *
 */
public class JobAllocationTestUtils{

	/**
	 * Adds the one to array.
	 *
	 * @param arrayOfMatrix
	 *            the array of matrix
	 * @return the boolean[]
	 */
	public static boolean[] addOneToArray(boolean[] arrayOfMatrix) {

		if(arrayOfMatrix[arrayOfMatrix.length - 1] == false) {
			arrayOfMatrix[arrayOfMatrix.length - 1] = true;
		} else {
			arrayOfMatrix[arrayOfMatrix.length - 1] = false;
			boolean toAddNext = true;
			for(int i = arrayOfMatrix.length - 2; i >= 0 && toAddNext == true; i--) {
				if(arrayOfMatrix[i] == true) {
					arrayOfMatrix[i] = false;
					toAddNext = true;
				} else if(arrayOfMatrix[i] == false) {
					arrayOfMatrix[i]=true;
					toAddNext = false;
				}
			}
		}

		return arrayOfMatrix;
	}


	/**
	 * Generate matrix out of array.
	 *
	 * @param arrayOfMatrix
	 *            the array of matrix
	 * @param size
	 *            the size
	 * @return the integer[][]
	 */
	public static Integer[][] generateMatrixOutOfArray(boolean[] arrayOfMatrix, int size) {
		Integer[][] result = new Integer[size][];
		for(int i = 0; i < size; i++) {
			int toMultiply = i; 
			result[i] = IntStream.range(0, size).boxed().map(element -> getOneOrZero(element+(toMultiply*size), arrayOfMatrix)).toArray(Integer[]::new);
		}
		return result;
	}

	/**
	 * Gets the one or zero.
	 *
	 * @param value
	 *            the value
	 * @param arrayOfMatrix
	 *            the array of matrix
	 * @return the one or zero
	 */
	private static Integer getOneOrZero(Integer value, boolean[] arrayOfMatrix) {
		if(arrayOfMatrix[value]) {
			return 1;
		}
		return 0;
	}


	/**
	 * Are all true.
	 *
	 * @param array
	 *            the array
	 * @return true, if successful
	 */
	public static boolean areAllTrue(boolean[] array)
	{
		for(boolean b : array) if(!b) return false;
		return true;
	}

	
}
