package com.demo;

import com.college.core.*;

public class Test2 {

	public static void main(String[] args) {
		Student ref = new Student("Kirtesh", "A", 2000, "DAC", 8900.00, 70.77);
		System.out.print(ref.toString());
		
		System.out.println("\n");
		
		Faculty ref2= new Faculty("Sangam", "M", 4, "Java Developer");
		System.out.print(ref2.toString());
		
		
	}

}
