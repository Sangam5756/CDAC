package com.test;

import static utils.StudentCollectionUtils.populateList;
import static utils.StudentCollectionUtils.populateMap;

import java.util.List;
import java.util.Map;

import com.app.core.Student;

public class Test1 {

	public static void main(String[] args) {

//		3.0 Display all student details from the student map.

//		first get that populated student  list
		List<Student> list = populateList();

//		now convert the list in to the map
		Map<String, Student> hm = populateMap(list);

//		now display the details of student from map using stream
		hm.values().stream().forEach(st -> System.out.println(st));
		

	}

}
