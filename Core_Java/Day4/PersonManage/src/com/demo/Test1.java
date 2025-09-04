package com.demo;

import com.college.core.*;

public class Test1 {

	public static void main(String[] args) {
		Person ref = new Student("Kirtesh", "A", 2000, "DAC", 8900.00, 70.77);
		System.out.print(ref.toString());
		
		System.out.println("\n");
		
		ref = new Faculty("Sangam", "M", 4, "Java Developer");
		System.out.print(ref.toString());
		
		
	}

}
