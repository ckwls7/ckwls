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
		   -��ü A�� B�� ��ġ���� Ȯ���Ѵ� 
		   - a:���� , b:�����, c:�������� */
	
		Calculator cal = new Calculator();
		int result = cal.sum(10,20);
		assertEquals(20, result, 10);
	}


}
