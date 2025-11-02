package com.cdac.tester;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cdac.dependent.PublicSchool;

public class TestSpringContainer {

	public static void main(String[] args) {
		// start SC
		try (ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("bean-config.xml")) {
			System.out.println("SC up n running !");
			//invoke B.L - manage academics
			//get rdy to use pub school bean instance from the SC
			PublicSchool school=ctx.getBean("public_school", PublicSchool.class);
			//B.L
			school.manageAcademics();
			//B.L
			school.organizeSportsEvent();
			System.out.println("----------------------------------");
			PublicSchool school2=ctx.getBean("public_school", PublicSchool.class);
			System.out.println(school==school2);//t
			
			
		} //JVM - ctx.close() -> SC chks for singleton beans - if yes - chks for destroy - if yes - invokes the same - GC
		catch (Exception e) {
			e.printStackTrace();
		}

	}

}
