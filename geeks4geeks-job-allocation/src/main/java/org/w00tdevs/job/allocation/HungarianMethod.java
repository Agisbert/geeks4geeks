package org.w00tdevs.job.allocation;


/**
 * @author agisbert
 *
 */
public interface HungarianMethod extends MinimunAllocation{

	/**
	 * Gets the allocation.
	 *
	 * @return the allocation
	 */
	int[] getAllocation();
}