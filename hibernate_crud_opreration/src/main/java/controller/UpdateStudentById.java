package controller;

import java.util.Scanner;

import hibernate_crud_opreration.dao.StudentDao;
import hibernate_crud_opreration.dto.Student;

public class UpdateStudentById {
public static void main(String[] args) {
	Scanner scanner=new Scanner(System.in);
	System.out.println(" enter The Id / Name");
	Student student=new StudentDao().updateStudentBYId(scanner.nextInt(), scanner.next());
	
	if (student!=null) {
		System.out.println(" Data is Upadated");
	} else {
		System.out.println(" Data is  Not Upadated");

	}
}
}
