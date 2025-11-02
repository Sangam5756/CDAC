package com.cdac.dependent;

import com.cdac.dependency.Coach;
import com.cdac.dependency.Teacher;

public class PublicSchool implements School {
	private Teacher subjectTeacher;
	private Coach sportsCoach;

	private PublicSchool(Teacher myTeacher) {
		System.out.println("In constructor - " + getClass());
		this.subjectTeacher = myTeacher;
	}

	@Override
	public void manageAcademics() {
		System.out.println("Managing academics here -");
		subjectTeacher.teach();
	}

	@Override
	public void organizeSportsEvent() {
		System.out.println("Preapring for sports event -");
		System.out.println("Daily Workout " + sportsCoach.getDailyWorkout());

	}

	// custom init method
	public void myInit() {
		System.out.println("in init of " + getClass());
	}

	// custom destroy method
	public void myDestroy() {
		System.out.println("in destroy of " + getClass());
	}

	// factory method based D.I
	public static PublicSchool myFactory(Teacher teacher123, Coach coach123) {
		System.out.println("in factory method");
		PublicSchool school = new PublicSchool(teacher123);
		school.sportsCoach = coach123;
		return school;
	}

}
