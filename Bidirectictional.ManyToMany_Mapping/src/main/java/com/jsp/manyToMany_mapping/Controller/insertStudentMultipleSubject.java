package com.jsp.manyToMany_mapping.Controller;

import com.jsp.manyToMany_mapping.DAO.Student_subject_DAO;
import com.jsp.manyToMany_mapping.DTO.Student;

public class insertStudentMultipleSubject {
	public static void main(String[] args) {
		Student student=new Student(203, "Lala", "gamil.com", 223, null);
		boolean result=new Student_subject_DAO().insertstudentList(student);
		System.out.println(result?" Data is Inserted":" Data is Not insertd");
	}
}
