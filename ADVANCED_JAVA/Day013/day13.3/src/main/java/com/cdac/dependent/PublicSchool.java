package com.cdac.dependent;

import com.cdac.dependency.Coach;
import com.cdac.dependency.Teacher;

public class PublicSchool implements School {
	private Teacher subjectTeacher;
	private Coach sportsCoach;

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

	@Override
	public void organizeSportsEvent() {
		System.out.println("Preapring for sports event -");
		System.out.println("Daily Workout "+sportsCoach.getDailyWorkout());
		
	}

	// custom init method
	public void myInit() {
		System.out.println("in init of " + getClass());
	}

	// custom destroy method
	public void myDestroy() {
		System.out.println("in destroy of " + getClass());
	}
	//seter based D.I - for optional depencdencies - coach

	public void setSportsCoach(Coach sportsCoach123) {
		System.out.println("in setter - coach");
		this.sportsCoach = sportsCoach123;
	}
	
	

}
