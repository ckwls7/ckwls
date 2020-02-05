package edu.bit.board.calculator;

import static org.junit.Assert.*;

import org.junit.Test;

public class CalculatorTest {

	/*
	 * @Test public void testSum() { fail("Not yet implemented"); }
	 */
	
	@Test
	public void testSum() {
		Calculator cal = new Calculator();
		int result = cal.sum(10,20);
		assertEquals(20, result, 10);
	}
	
	@Test
	public void testSub() {
		/* assertEquals(a,b,c) 
		   -객체 A와 B가 일치함을 확인한다 
		   - a:예상값 , b:결과값, c:오차범위 */
	
		Calculator cal = new Calculator();
		int result = cal.sum(10,20);
		assertEquals(20, result, 10);
	}


}
