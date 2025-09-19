package com.test;

import static utils.StudentCollectionUtils.populateList;
import static utils.StudentCollectionUtils.populateMap;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.app.core.Student;
import com.app.core.Subject;

import custom_exception.StudentCollectionException;

public class Test4 {

	public static void main(String[] args) {

//		3.3 Print name of specified subject  topper
//		i/p : subject name

//		first get that populated student  list
		List<Student> list = populateList();

//		now convert the list in to the map
		Map<String, Student> hm = populateMap(list);
		Comparator<Student> comp = ((p1,p2) -> Double.compare(p1.getGpa(), p1.getGpa()));

////			first need to get the 
//		Optional<Student> max = hm.values().stream().filter(s -> s.getSubject() == Subject.DBT)
//				.max(comp);
//
//		
////		using is present
//		if (max.isPresent()) {
//			System.out.println("The JAVA topper is: " + max.get().getName());
//		} else {
//			System.out.println("No student found for the subject JAVA.");
//		}
		
//		using proper error handling
//		first need to get the 
	Optional<Student> max1 = hm.values().stream().filter(s -> s.getSubject() == Subject.DBT)
			.max(comp);
	
	try {
		Student top = max1.orElseThrow(()-> new StudentCollectionException("No Topper is Found"));
		System.out.println(top.getName());
	} catch (StudentCollectionException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	
	}

}
