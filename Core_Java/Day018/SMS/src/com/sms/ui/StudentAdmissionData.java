package com.sms.ui;

import com.sms.ServiceImpl.StudentServiceImpl;
import com.sms.services.StudentService;

public class StudentAdmissionData {
	public static void main(String[] args) {

		try {
			StudentService service = new StudentServiceImpl();
//			service.admitStudent("D", "d@gmail.com", 90, "mern");
			service.displayData();
			service.serial();
			service.deserial();
			
			
					
				
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
