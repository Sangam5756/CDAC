package com.cdac.dependent;

import com.cdac.dependency.Teacher;

public class PublicSchool implements School {
	private Teacher subjectTeacher;

	// Constructor based D.I - reco.
	public PublicSchool(Teacher myTeacher) {
		System.out.println("In constructor - " + getClass());
		this.subjectTeacher = myTeacher;
	}

	@Override
	public void manageAcademics() {
		System.out.println("Managing academics here -");
		subjectTeacher.teach();
	}

	// custom init method
	public void myInit() {
		System.out.println("in init of " + getClass());
	}

	// custom destroy method
	public void myDestroy() {
		System.out.println("in destroy of " + getClass());
	}

}
