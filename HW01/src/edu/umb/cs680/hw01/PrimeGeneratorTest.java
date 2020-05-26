package edu.umb.cs680.hw01;

import org.junit.Test;

public class PrimeGeneratorTest 
{
	@Test
	public void oneToTen() 
	{
		PrimeGenerator gen = new PrimeGenerator(1, 10);
		gen.generatePrimes();
		Long[] expectedPrimes = {2L, 3L, 5L, 7L};
		assertArrayEquals( expectedPrimes,gen.getPrimes().toArray());
				
	}
	
	private void assertArrayEquals(Long[] expectedPrimes, Object[] array) 
	{
		// TODO Auto-generated method stub
		
	}

	@Test
	public void tenTo20() 
	{
		PrimeGenerator gen = new PrimeGenerator(10,20);
		gen.generatePrimes();
		Long[] expectedPrimes = {11L, 13L, 17L, 19L};
		assertArrayEquals( expectedPrimes,gen.getPrimes().toArray());
		
		
	}
}

