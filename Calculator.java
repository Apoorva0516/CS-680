package edu.umb.cs680.hw01;

public class Calculator 
{
	
	public float multiply(float a,float b)
	{

		return a*b;
		
	}
	public float divide(float a, float b)
	{
		if(b==0)
		{	
			throw new IllegalArgumentException("division error ");
		}
		return a/b;
	}
	public float additon(float a, float b)
	{
		return a+b;
	}
	public float subtraction(float a, float b)
	{
		return a-b;
	}
public static void main(String[] args)
{
	Calculator cal = new Calculator ();
	cal.multiply(3,2);
	
	
	
}
}

