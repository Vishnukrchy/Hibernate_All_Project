package controller;

import java.util.List;

import hibernate_crud_opreration.dao.StudentDao;
import hibernate_crud_opreration.dto.Student;

public class GetAllStudentDetails {
public static void main(String[] args) {
	List<Student> stList=new StudentDao().getAllStudent();
	if (stList!=null) {
		for (Student student : stList) {
			System.out.println(student);
		}
	} else {
          System.out.println(" Student detail;s is n ot Found");
	}
}
}
