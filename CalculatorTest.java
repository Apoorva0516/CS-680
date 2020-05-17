package edu.umb.cs680.hw01;


	import static org.junit.Assert.*;
	import static org.hamcrest.CoreMatchers.*;
	import org.junit.Test;

	public class CalculatorTest {
		@Test
		public void multiply3by4()
		{
				Calculator cut = new Calculator();
				float expected = 12;
				float actual = cut.multiply(3,4);
				assertThat(actual,is(expected));
		}
		@Test
		public void divide3by2()
		{
				Calculator cut = new Calculator();
				float expected = 1.5f;
				float actual = cut.divide(3,2);
				assertThat(actual,is(expected));
		}
		@Test(expected= java.lang.IllegalArgumentException.class)
		public void divide5by0()
		{
				Calculator cut = new Calculator();
				cut.divide(5,0);
		}
		@Test
		public void multiply5by5()
		{
			Calculator cut = new Calculator();
			float expected = 25;
			float actual = cut.multiply(5,5);
			assertThat(actual,is(expected));
		}
		@Test
		public void divide5by5()
		{
			Calculator cut = new Calculator();
			float expected = 1;
			float actual = cut.divide(5,5);
			assertThat(actual,is(expected));
		}
		
		

	}


