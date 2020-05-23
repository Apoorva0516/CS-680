package edu.umb.cs680.hw01;

import static org.junit.jupiter.api.Assertions.*;



import org.junit.jupiter.api.Test;

class PrimeGeneratorTest {

	@Test
	public void oneToTen() {
		PrimeGenerator gen = new PrimeGenerator(1, 10);
		gen.generatePrimes();
		Long[] expectedPrimes = {2L, 3L, 5L, 7L};
		assertArrayEquals( expectedPrimes,gen.getPrimes().toArray());
				
	}
	
	@Test
	public void tenTo20() {
		PrimeGenerator gen = new PrimeGenerator(10,20);
		gen.generatePrimes();
		Long[] expectedPrimes = {11L, 13L, 17L, 19L};
		assertArrayEquals( expectedPrimes,gen.getPrimes().toArray());
		
		
	}


	
	@Test
	public void negoneTo5() {
		PrimeGenerator gen = new PrimeGenerator(-5,-1);
		gen.generatePrimes();
		Long[] expectedPrimes = {};
		assertArrayEquals( expectedPrimes,gen.getPrimes().toArray());	
	
	}
	
	
}