package edu.umb.cs680.hw03;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertArrayEquals;



class StudentTest {
	private String[] InStateStudentToStringArray(Student s){
		String[] StudentInfo = 
			{ 
				s.getName(), s.get_us_Addr(), Integer.toString(s.getyrsInState()) 
			};
		return StudentInfo;
		}
	
	private String[] OutStateStudentToStringArray(Student s){
			String[] StudentInfo = 
				{ 
					s.getName(), s.get_us_Addr()
				};
		return StudentInfo;
	}	
	
	private String[] IntlStudentToStringArray(Student s){
		String[] StudentInfo = 
			{ 
				s.getName(), s.get_us_Addr(), Integer.toString(s.geti20num()), s.get_foreign_Addr()
			};
	return StudentInfo;
	}	
	
	@Test
	public void verify_In_state_student() {
		String[] expected = {"Rajath", "Boston", "25"};
		Student actual= Student.createInStateStudent("Rajath", "Boston", 25);
		assertArrayEquals(expected, InStateStudentToStringArray(actual));
	}

	@Test
	public void verify_Out_State_student() {
		String[] expected = {"Raj", "Boston"};
		Student actual= Student.createOutStateStudent("Raj", "Boston");
		assertArrayEquals(expected, OutStateStudentToStringArray(actual));
	} 
	
	@Test
	public void verify_Inl_student() {
		String[] expected = {"Rajath", "Boston", "565622", "India"};
		Student actual= Student.createIntlStudent("Rajath", "Boston", 565622, "India");
		assertArrayEquals(expected, IntlStudentToStringArray(actual));
	} 
}
