package org.w00tdevs.job.allocation;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author agisbert
 *
 */
public class JobAllocationTests{

	@Test
	public void TestHungarianMethod() {
		int i = 4;
		boolean[] arrayOfMatrix = new boolean[i*i];
		while(!JobAllocationTestUtils.areAllTrue(arrayOfMatrix)) {
			Integer[][] matrix = JobAllocationTestUtils.generateMatrixOutOfArray(arrayOfMatrix, i);
			MinimunAllocation jobsAlloc = new HungarianMethodImpl(matrix);
			jobsAlloc.getMinimunAssigment();
			arrayOfMatrix = JobAllocationTestUtils.addOneToArray(arrayOfMatrix);
		}
	}

	@Test
	public void TestRecursiveMethod() {
		int i = 4;
		boolean[] arrayOfMatrix = new boolean[i*i];
		while(!JobAllocationTestUtils.areAllTrue(arrayOfMatrix)) {
			Integer[][] matrix = JobAllocationTestUtils.generateMatrixOutOfArray(arrayOfMatrix, i);
			MinimunAllocation jobsAlloc = new JobAllocationRecursiveAlg(matrix);
			jobsAlloc.getMinimunAssigment();
			arrayOfMatrix = JobAllocationTestUtils.addOneToArray(arrayOfMatrix);
		}
	}

	@Test
	public void testBigMatrixHungarianMethod() {
		Integer[][] matrix = new Integer[][]{{2, 1, 2},{ 9, 8, 1}, {1, 1, 1}};
		long timeInit = System.currentTimeMillis();
		MinimunAllocation jobsAlloc = new HungarianMethodImpl(matrix);
		Integer minAssignment = jobsAlloc.getMinimunAssigment();
		long timeEnd = System.currentTimeMillis();
		Assert.assertTrue(Integer.valueOf(3).equals(minAssignment));
		System.out.println("Hungarian method took -> " + (timeEnd-timeInit) + "ms");
	}

	@Test
	public void testBigMatrixRecMethod() {
		Integer[][] matrix = new Integer[][]{{2, 1, 2},{ 9, 8, 1}, {1, 1, 1}};
		long timeInit = System.currentTimeMillis();
		MinimunAllocation jobsAlloc = new JobAllocationRecursiveAlg(matrix);
		// this takes a while...
		Integer minAssignment = jobsAlloc.getMinimunAssigment();
		long timeEnd = System.currentTimeMillis();
		Assert.assertTrue(Integer.valueOf(3).equals(minAssignment));
		System.out.println("Recursive method took -> " + (timeEnd-timeInit) + "ms");
	}
}	
