package com.test;

import static utils.StudentCollectionUtils.populateList;
import static utils.StudentCollectionUtils.populateMap;

import java.util.List;
import java.util.Map;

import com.app.core.Student;

public class Test3 {

	public static void main(String[] args) {

//		3.2 Print sum of  marks of students of all students from the specified state
//		i/p : name of the state

//		first get that populated student  list
		List<Student> list = populateList();

//		now convert the list in to the map
		Map<String, Student> hm = populateMap(list);

		
		double marks =hm.values().stream()
		.filter(s -> s.getAddress().getState().equals("MH"))
		.mapToDouble( m -> m.getGpa()).sum();
		
		System.out.println(marks);
		
		

	}

}
