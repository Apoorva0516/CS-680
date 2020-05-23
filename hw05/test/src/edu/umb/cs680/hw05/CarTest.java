package edu.umb.cs680.hw05;

import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.hamcrest.core.IsNot;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestTemplate;


class CarTest {
	
	private String[] CarToStringArray(Car c)
	{
		String [] carInfo = 
			{
				c.getMake(),c.getModel(),Integer.toString(c.getYear())
			};
		return carInfo;
	}
	
	
	@Test
	public void verifyCarEqualityWithMakeModelYear() {
		String[] expectedStrings = {"Tesla","Model S","2020"};
		Car actual = new Car("Tesla","Model S",2020);
		assertArrayEquals(expectedStrings, CarToStringArray(actual));
		}
	
	@Test
	public void verifyCarEqualityWithMakeModelYear_NotEqual()
	{
		String[] expected = {"Lambhorgini","Gallardo","2019"};
		Car actual = new Car("Lamborghini","Gallardo",2020);
		assertNotEquals(expected, CarToStringArray(actual));
	}

}




