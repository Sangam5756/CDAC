package com.test;

import static utils.StudentCollectionUtils.populateList;
import static utils.StudentCollectionUtils.populateMap;

import java.util.List;
import java.util.Map;

import com.app.core.Student;
import com.app.core.Subject;

public class Test2 {

	public static void main(String[] args) {

//		3.1 Display  details of the students from  specified subject 

//		first get that populated student  list
		List<Student> list = populateList();

//		now convert the list in to the map
		Map<String, Student> hm = populateMap(list);

//		now display the details of student from map using stream
//		hm.values().stream().forEach(st -> System.out.println(st));
		
//		here will get the subject name
		Subject sub = Subject.JAVA;
		
//		now using stream will filter the subject then will show the details
		hm.values().stream().filter(f -> f.getSubject() == sub)
		.forEach(s -> System.out.println(s));
		
		
		
		

	}

}
