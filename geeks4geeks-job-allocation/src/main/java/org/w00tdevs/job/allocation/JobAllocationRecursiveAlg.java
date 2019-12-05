package org.w00tdevs.job.allocation;

import java.util.ArrayList;
import java.util.List;



/**
 * @author agisbert
 * Recursive solution for getting the minimin allocation
 * 
 * Not good enough with big matrixes.
 */
public class JobAllocationRecursiveAlg implements MinimunAllocation{

	/** The emp jobs. */
	private Integer[][] empJobs;

	/**
	 * Instantiates a new job allocation recursive alg.
	 *
	 * @param matrix
	 *            the matrix
	 */
	public JobAllocationRecursiveAlg(Integer[][] matrix) {
		super();
		this.empJobs = matrix;
	}


	/* (non-Javadoc)
	 * @see org.w00tdevs.job.allocation.MinimunAllocation#getMinimunAssigment()
	 */
	@Override
	public Integer getMinimunAssigment() {
		return getRec(new ArrayList<Integer>(), empJobs);
	}


	/**
	 * Gets the rec.
	 *
	 * @param assigned the assigned
	 * @param empJobs the emp jobs
	 * @return the rec
	 */
	private int getRec(List<Integer> assigned, Integer[][] empJobs) {
		if(assigned.size() < empJobs.length) {	
			int cost = Integer.MAX_VALUE;
			for(int i = 0; i < empJobs.length; i++) {
				if(!assigned.contains(i)) {
					List<Integer> auxList = new ArrayList<Integer>(assigned);
					auxList.add(i);
					int aux = empJobs[assigned.size()][i] + getRec(auxList, empJobs);
					cost = aux < cost ? aux : cost;
				}
			}	
			return cost;
		}else {
			return 0;
		}
	}




}
