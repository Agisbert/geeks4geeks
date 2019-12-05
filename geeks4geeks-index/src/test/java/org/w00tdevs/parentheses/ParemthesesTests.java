package org.w00tdevs.parentheses;

import org.junit.Assert;
import org.junit.Test;

/**
 * The Class IndexUtils.
 */
public class ParemthesesTests {

	@Test
	public void simpleTestEmpty() {
		long dist = ParenthesesProblem.getLongOfValidParentheses("");
		Assert.assertEquals(0, dist);
	}
	
	@Test
	public void simpleTest1() {
		long dist = ParenthesesProblem.getLongOfValidParentheses("((()");
		Assert.assertEquals(2, dist);
	}
	
	@Test
	public void simpleTest1I() {
		long dist = ParenthesesProblem.getLongOfValidParentheses("(()()(((())");
		Assert.assertEquals(4, dist);
	}
	
	
	@Test
	public void simpleTest2() {
		long dist = ParenthesesProblem.getLongOfValidParentheses(")()())");
		Assert.assertEquals(4, dist);
	}

	@Test
	public void simpleTest3() {
		long dist = ParenthesesProblem.getLongOfValidParentheses("()(((()())");
		Assert.assertEquals(6, dist);
	}
	

	@Test
	public void simpleTest3II() {
		long dist = ParenthesesProblem.getLongOfValidParentheses("(()()(((())))");
		Assert.assertEquals(12, dist);
	}

	@Test
	public void simpleTest3I() {
		long dist = ParenthesesProblem.getLongOfValidParentheses(")()())(()()()(");
		Assert.assertEquals(6, dist);
	}

	@Test
	public void simpleTest4() {
		long dist = ParenthesesProblem.getLongOfValidParentheses("))))()))()))))(())())())())))))))()(()(()(()()(((((()((()())())(())()()))()()()()()((()())()((()()((((()(((()))(()))()((()()(())()()()))()())((((())(()))()()()((())))(())())))(())(()((()()((())()))()))(())((((())())()((())())(()(()()(())))()))())))(((())())))(())))())())(()(()()((()()(())((((((()))())(())()((())(()))))(()()())())))(()()))((())))(((())(((()())()())(())))(())()()()()))(())(()))))())())(()()()())))))((()())())(()(()))()()((()(())()()))))())))()(()(())()()))()))))())()))())))(()))()(((((()()()))))(()()(()()()))()()((((()())()(()))()(())(())(()(()))((())(())))))))(())))))()()(())))()))()(((()()())()))())))(((((()((()()()(((((()))))())(()))((()))()((())(())())()()((()(()()(()()))(()())()((())))((((()()))()(()()()())()()(()(((())))())(())))))()(()))((()(((()(()(()()((((((()())(()))()()()))))(())((()))(())))(()(()()))(()((())((())))((()((())(())))(((()(()()()(()(())(())))(())()())))(()))))((())((()())(()(((())(()))())((()))((()()))()))((()((()((()))(()((()))())(()(()(()))()()(()()))(((()(())))))()())()()))(()())(())())))))))))(()((((((())(()))))(()(()(((()()(()))((()))(()())(((()))()()))(((()))(()(((()(())))))))()(()()))())(()(((()()())())()))(((())(((((((())(())(()))))(((()))(()()))(((((()(()))())((()))))()((((((()())))())()()((()((()())((()()((((()()))))()()()))()(()))(((()(())((((((((((()(())(((()()(()()(())((()))((((())())((((())))()(()()))))))))(()(((())((((((()()()(()())())(()))(()((()()()(()(())))())))()(()))()()(((()))()())(())()))()())()((()))(()(()())(((((())(()))()))()))))(((((((()(()))))((((()())()(()()()()(()))())()()()(()(())(((()((((())()))))()(()(((())))((()))(((((())(()))(()((())())(())())(()))())(((())))(((())()())(()()(())(()))(()(())((((()()))())()))()())()))(()()((()))(()()))(())))())())(()(()))())()()())((((((((())))(()())()))(())(())()()(()))))))))(()()(())())))()(()()(((((())()()))(()((())()()())))()()(()()))((())(())()(((()(((()((())())))((((()(())()))()((((()))())())()((()()))(()()((()())()))))(()((()))(()()((((()(((((())())((())))()())()))(((()(()))))()()))))))(()(((((()(()()(()((()))())())))()(((())(((((()))()())(()())())()))(())))()(()(()())(((()()()))))))(())(())))(()(()))())())())(((())()(()((()((()))(()())(())((())()))((())(((()((((()(()(())(()())()()()))()((()))(())(()((()()))()()(()(()())(()())(((())))))))))()(()))(()(((()()()(())()))))))()())))((()))))))))(((()(())())())(()))((()(()(()))(()))())((()((()((()))))((()(()())(()((())()())))(()(())))))((()()((()))(())))())))((())()))(()((()))()())()())()()))))(()()()()())((()(()))))((()(()()(())))()(()()(()(()())(()()((()())())))()))))))(())((()())))()(())())())))())(())(((())())()()(()()())())))()(()()())(((((()()))()()))))(((())((()(((()))((()(((()((()()((((()())))(()(())()()()((()(()))(((())(())))()))()(()))(())))))(())))(()(()(((()())())))())()(()(()(((())(()))))()((()()))((()())((())()(())(())(())(())()()))))(((((((())(((())))()(()(((()()))()((())()()()))))())))()())))))))((()()))())()))(()(((((((()))))(()())))())())(((()()))((((((()())))))))))()()()()(()()(()()((()())()(((()())(((())()()(((())()((((()))(())(((()(((()()(())(()()()(())(()((())((()()((()(()))()(()(())()()(()))()((((())))()(())((((()()))())())(()))))()(((((())))((((())))))((((()((((())))())())))()))))))((())((()))())(((((((((((((()((()()))((()))))()()(()))()))()(((()(()()(()((()()()((())())))((()((())((()()(()())((((()(((()))))(()((()()())(()())(((()()((())((((())((()(((((((()(((())((((())((((((()()(((()()))((((()()()))((((())())(())(()(()))()()))(())))(()(()))()))()())))))()))(())))(((()(()(()()(()(()(())()(()(((()))(((()))))(()))))())))(((()))()))((()(()()(((((())())))(()((((((()((()()()()((((()(()(()))(()(((())()(((((()))(()))()(()))()()(()()()()())()))(())))(()(()(()))(())(())))()(())))))(((()()(((())())(()(()()(()(())((())))(((()))))(())())()()(()()))))))()))))()))))(((()()))(()(()((())()(())())()()()()((())()((())(((())())()()))()()()()()))((()()())))))()(()((()()())))))()(((((((((((()))))(()))())()())((()()()(())))())())())(())(()())()(()((((((()()(()()))())))())((())((()((()())())))))(()((((())))(())((()((())())(())))(()())((())(())))((((())(((((()()))))((()))())())()())()))(((()(())))(()()(())))())))()))()(()()(()())()))())(()(())))))()))((())(()())())))(()())())(())()()(()())))())()))((((()()))))()(())(())()(())()))()(()(()(()((()(())())(((((()((((()))()()()))(()()(()()()())))))())())))(()))))()())))((()(()((()()))))((((((()(()(()))())()()(()(()))((((())((())())()((((((()())())()()(())))))(())(())((()(()()(((()()())()((())((((()))))((())((((((((()()))))(((())(()()(()()))((())(((((()()()())((()()())())(()((()))(())()(()()()))())(()()(()))))()(()((()(())()())(())()()))(())()(((((())(((()))(()())(((())()((()))(((())())()())(()))(()())))(())))())(()()))))((((())()(()((((()()))(())(()(()()()())(((())(((((((())()()())(()))()))(()()((())((((()))(()())())(()()(()()(()()()())()()())()((()()))))))((()()))(()()))(((())))())))()()()())()())(((())(()(()(()()((())(()())((()))()))())))(())()())((((((())))))()))())()(((()()((()))(((())())(((()(()))(((()()()(()))())((()))(())))))((((()()))()())()()(((()))(()(()((()()()()))))(()()()))()()))()()()))()(()()()(((())()(((())))(()(())(()())))((())()))()(()))(()())(((()(((()))())(())())()))()(()()())))(())(()()()())(()()((()()))())()(())())()))))())))(((())()(())(((()))))))))))))))()))))((()(()()((((((((()(()()())())((()(((()((()))()(())))()(())((())((()(())))))))(()((()))()()()))))()(()(((()()())((((()()(((()(()()()))(((()(())))(((()())()))()(((()((())))())()(()((((()((((()))))(())())()))(((()()))(()))()())(((((((())()(())(()(((((((())())))()((((((())()())()))((()()())))()()()()(()(()()(()((()(()(()(()()))))(((()(()()((())))()()()(((((((()(()()((()()(()(())))()))((((((())(()(((()()(()(()()())((()))())(()()()((())()())()(()))))())((()((()()(()())()))((((((())))((()))())((())()(((())))))())()))()))()))(()))((()())())(())())())))())()())((()())()))())(((()(()()(()())((()()()(()())))((())()((()())((())))()))(()(()())()((()(()(((())(())())))))((()()))()))())()(())))))())()))(())(()(((()(((()((");
		Assert.assertEquals(1974, dist);
	}
	
}