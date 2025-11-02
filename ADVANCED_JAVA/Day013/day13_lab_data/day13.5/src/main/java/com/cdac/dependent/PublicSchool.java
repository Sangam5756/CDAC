package com.cdac.dependent;

import com.cdac.dependency.Coach;
import com.cdac.dependency.Teacher;

public class PublicSchool implements School {
	private Teacher subjectTeacher;
	private Coach sportsCoach;

	public  PublicSchool() {
		System.out.println("In constructor - " + getClass());
		
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

	//byName - setter / depedency
	public void setSubjectTeacher(Teacher subjectTeacher) {
		System.out.println("in setter - teacher");
		this.subjectTeacher = subjectTeacher;
	}

	public void setSportsCoach(Coach sportsCoach) {
		System.out.println("in setter - coach");
		this.sportsCoach = sportsCoach;
	}

	
	

}
