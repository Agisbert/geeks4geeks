package org.w00tdevs.job.allocation;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


/**
 * @author agisbert
 *
 * Hungarian method solution for assignment problem
 *
 */
public class HungarianMethodImpl implements HungarianMethod{

	/** The jobs employees. */
	private Integer[][] jobsEmployees;

	/**
	 * Instantiates a new jobs allocation.
	 *
	 * @param jobsEmployees the jobs employees
	 */
	public HungarianMethodImpl(Integer[][] jobsEmployees) {
		super();
		this.jobsEmployees = jobsEmployees;
	}

	/* (non-Javadoc)
	 * @see org.w00tdevs.job.allocation.HungarianMethod#getAllocation()
	 */
	@Override
	public int[] getAllocation() {
		return Arrays.stream(getAssingmentByHungMethod()).mapToInt(element -> element.intValue()).toArray();
	}

	/* (non-Javadoc)
	 * @see org.w00tdevs.job.allocation.HungarianMethod#getMinimunAssigment()
	 */
	@Override
	public Integer getMinimunAssigment() {
		Integer[] assingment = this.getAssingmentByHungMethod();
		return IntStream.range(0, assingment.length).map(index -> this.jobsEmployees[index][assingment[index]]).sum();
	}

	/**
	 * Gets the assingment by hung method.
	 *
	 * @return the assingment by hung method
	 */
	private Integer[] getAssingmentByHungMethod() {
		Integer[][] jobsEmployeesCopy = new Integer[this.jobsEmployees.length][this.jobsEmployees.length];
		IntStream.range(0, this.jobsEmployees.length).forEach(x -> IntStream.range(0, this.jobsEmployees.length).forEach(y -> jobsEmployeesCopy[x][y] = this.jobsEmployees[x][y]));
		Integer[][] jobsEmployeesProcessed = prepareMatrixHungarianMethod(jobsEmployeesCopy);
		return iterateHungarianMethod(jobsEmployeesProcessed);
	}

	/**
	 * Prepare matrix hungarian method.
	 *
	 * @param jobsEmployeesToPrepare the jobs employees to prepare
	 * @return the integer[][]
	 */
	private Integer[][] prepareMatrixHungarianMethod(Integer[][] jobsEmployeesToPrepare) {
		// Hungarian method. well explained here -> http://www.hungarianalgorithm.com/examplehungarianalgorithm.php
		// step 1, substract minimun by rows.
		for(Integer [] row : jobsEmployeesToPrepare) {
			Integer minVal = Collections.min(Arrays.asList(row));
			IntStream.range(0,row.length).forEach(index -> row[index] -= minVal);
		}
		// step 2, substract minimun by col, note migh be 0s. Assuming NxN matrix... 
		for(int i = 0; i < jobsEmployeesToPrepare.length; i++) {
			Integer minVal = null;
			for(int j = 0; j < jobsEmployeesToPrepare.length; j++) {
				if(minVal == null || minVal > jobsEmployeesToPrepare[j][i]) {
					minVal = jobsEmployeesToPrepare[j][i];
				}
			}
			for(int j = 0; j < jobsEmployeesToPrepare.length && minVal > 0; j++) {
				jobsEmployeesToPrepare[j][i] -= minVal;
			}
		}
		return jobsEmployeesToPrepare;
	}

	/**
	 * Iterate hungarian method.
	 *
	 * @param jobsEmployeesProcessed the jobs employees processed
	 * @return the integer[]
	 */
	private Integer[] iterateHungarianMethod(Integer[][] jobsEmployeesProcessed) {
		// based on -> http://tryalgo.org/en/matching/2016/08/05/konig/
		// and https://pythonhosted.org/tryalgo/_modules/tryalgo/bipartite_matching.html
		Integer[] matchV  = max_bipartite(jobsEmployeesProcessed);
		Integer[] matchU = buildReverseRelation(matchV);
		boolean[] visitedU = new boolean[matchU.length];
		boolean[] visitedV = new boolean[matchV.length];

		for(int i = 0; i < matchU.length; i++) {
			if(matchU[i] == null) {
				doTheVisits(i, jobsEmployeesProcessed, visitedU, visitedV, matchV);
			}
		}

		List<Integer> rowsWithZeros = IntStream.range(0, jobsEmployeesProcessed.length).boxed().filter(element -> !visitedU[element]).collect(Collectors.toList());
		List<Integer> colsWithZeros = IntStream.range(0, jobsEmployeesProcessed.length).boxed().filter(element -> visitedV[element]).collect(Collectors.toList());


		if(colsWithZeros.size() + rowsWithZeros.size() == jobsEmployeesProcessed.length) {
			return matchU;
		}else {
			// no solution, yet. 
			Integer minVal = null;
			for(int i = 0; i < jobsEmployeesProcessed.length; i++) {
				for(int j = 0; j < jobsEmployeesProcessed[i].length; j++) {
					if(minVal == null && !rowsWithZeros.contains(i) && !colsWithZeros.contains(j)) {
						minVal = jobsEmployeesProcessed[i][j];
					}else if(!rowsWithZeros.contains(i) && !colsWithZeros.contains(j)) {
						minVal = minVal < jobsEmployeesProcessed[i][j] ? minVal : jobsEmployeesProcessed[i][j];
					}
				}
			}
			for(int i = 0; i < jobsEmployeesProcessed.length; i++) {
				for(int j = 0; j < jobsEmployeesProcessed[i].length; j++) {
					if(!rowsWithZeros.contains(i) && !colsWithZeros.contains(j)) {
						jobsEmployeesProcessed[i][j] -= minVal;
					}else if(rowsWithZeros.contains(i) && colsWithZeros.contains(j)) {
						jobsEmployeesProcessed[i][j] += minVal;
					}
				}
			}
			return iterateHungarianMethod(jobsEmployeesProcessed);
		}

	}


	/**
	 * Builds the reverse relation.
	 *
	 * @param matchV the match V
	 * @return the integer[]
	 */
	private Integer[] buildReverseRelation(Integer[] matchV) {
		Integer[] matchU = new Integer[matchV.length];
		for (int i = 0; i < matchV.length; i++) {
			Integer integer = matchV[i];
			if(integer != null) {
				matchU[integer] = i;
			}

		}
		return matchU;
	}

	/**
	 * Max bipartite.
	 *
	 * @param jobsEmployeesProcessed the jobs employees processed
	 * @return the integer[]
	 */
	private Integer[] max_bipartite(Integer[][] jobsEmployeesProcessed) {
		Integer[] matching = new Integer[jobsEmployeesProcessed.length];
		for(int i = 0; i < jobsEmployeesProcessed.length; i++) {
			// modifying matching by ref
			doTheMatch(i, jobsEmployeesProcessed, new boolean[jobsEmployeesProcessed.length], matching);
		}
		return matching;
	}

	/**
	 * Do the match.
	 *
	 * @param row the row
	 * @param jobsEmployeesProcessed the jobs employees processed
	 * @param visited the visited
	 * @param matching the matching
	 * @return the integer[]
	 */
	private boolean doTheMatch(Integer row, Integer[][] jobsEmployeesProcessed, boolean[] visited, Integer[] matching) {
		for(int index = 0; index < jobsEmployeesProcessed.length; index++) {
			if(jobsEmployeesProcessed[row][index] == 0 && !visited[index]) {
				visited[index] = true;
				if(matching[index] == null || doTheMatch(matching[index], jobsEmployeesProcessed, visited, matching)) {
					matching[index] = row;
					return true;
				}
			}
		}
		return false; 
	}


	/**
	 * Do the visits. Void method. be careful, modofies by ref...
	 *
	 * @param u the u
	 * @param jobsEmployeesProcessed the jobs employees processed
	 * @param visitedU the visited U
	 * @param visitedV the visited V
	 * @param matchV the match V
	 */
	private void doTheVisits(Integer u, Integer[][] jobsEmployeesProcessed, boolean[] visitedU, boolean[] visitedV, Integer[] matchV) {
		visitedU[u] = true; 
		for(int i = 0; i < jobsEmployeesProcessed[u].length; i++) {
			if(jobsEmployeesProcessed[u][i] == 0) {
				if(!visitedV[i]) {
					visitedV[i] = true;
					if(matchV[i] != null) {
						doTheVisits(matchV[i], jobsEmployeesProcessed, visitedU, visitedV, matchV);
					}
				}
			}
		}
	}


	/**
	 * The Class Vertix. Used to help
	 */
	public class Vertix{

		/** The i. */
		public int i;

		/** The j. */
		public int j;

		/**
		 * Instantiates a new vertix.
		 *
		 * @param i the i
		 * @param j the j
		 */
		public Vertix(int i, int j) {
			super();
			this.i = i;
			this.j = j;
		}

	}

}