package com.healthcare.doctortest;

import java.util.Scanner;

import com.healthcare.dao.DoctorDao;
import com.healthcare.dao.DoctorDaoImpl;

public class DisplayDoctorsBySepciality {

	public static void main(String[] args) {
		try (Scanner sc=new Scanner(System.in)) {
			//1. create dao instance
			DoctorDao dao=new DoctorDaoImpl();
			//clnt servicing phase 
			System.out.println("Enter speciality");
			System.out.println("Docs by speciality - ");
			dao.findBySpeciality(sc.next())
			.forEach(System.out::println);
			
			//3. destroy - clean up
			dao.cleanUp();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
