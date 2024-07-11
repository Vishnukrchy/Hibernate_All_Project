package com.jsp.hibernate_OneToMany_Controller;

import com.jsp.hibernate_OneToMany_Dao.StudentTrainerDao;

public class DeleteTrainerStudentController {
public static void main(String[] args) {
	boolean result=new StudentTrainerDao().deleteBYId(102);
	if (result ) {
		System.out.println(" Data is Deleted");
	} else {
		System.out.println(" Data Not not deletd");

	}
}
}
