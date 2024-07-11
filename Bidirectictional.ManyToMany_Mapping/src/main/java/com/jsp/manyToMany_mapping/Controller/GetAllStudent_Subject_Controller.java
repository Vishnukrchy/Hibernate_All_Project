package com.jsp.manyToMany_mapping.Controller;

import java.util.List;
import com.jsp.manyToMany_mapping.DAO.Student_subject_DAO;
import com.jsp.manyToMany_mapping.DTO.Student;

public class GetAllStudent_Subject_Controller {
	public static void main(String[] args) {
		List<Student> stuList = new Student_subject_DAO().getAllStudentAndSubjectDao();
		stuList.forEach(student -> System.out.println(student));
		
		System.out.println("======================================================================");
        stuList.forEach(student -> {
            System.out.println("Student ID: " + student.getId());
            System.out.println("Name: " + student.getName());
            System.out.println("Email: " + student.getEmail());
            System.out.println("Phone: " + student.getPhone());
            System.out.println("Subjects: ");
            student.getSubList().forEach(subject -> {
                System.out.println("    Subject ID: " + subject.getId());
                System.out.println("    Name: " + subject.getName());
                System.out.println("    Author: " + subject.getAuthorName());
                System.out.println("    Publish Year: " + subject.getPublishYear());
                System.out.println("    Price: " + subject.getPrice());
            });
        });

	}
}
