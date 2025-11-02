package com.cdac.tester;

import com.cdac.dependency.EnglishTeacher;
import com.cdac.dependent.PublicSchool;
import com.cdac.dependent.School;

public class TestSchool {

	public static void main(String[] args) {
		School school=new PublicSchool(new EnglishTeacher());
		school.manageAcademics();

	}

}
