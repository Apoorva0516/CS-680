package edu.umb.cs680.hw02;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;




class CalculatorTest {

	@Test
	public void multiply7and8() {
		Calculator cal = new Calculator();
		float actual = cal.multiply(7,8);
		float expected = 56;
		assertEquals(actual,expected);
		
	}
	
	
	@Test
	public void divide72by9() {
		Calculator cal= new Calculator();
		float actual = cal.divide(72, 9);
		float expected = 8;
		assertEquals(actual,expected);
	}
	

}
