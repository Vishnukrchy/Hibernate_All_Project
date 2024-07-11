package controller;

import java.util.Scanner;

import hibernate_crud_opreration.dao.StudentDao;

public class DeleteById {
public static void main(String[] args) {
	Scanner scanner=new Scanner(System.in);
	System.out.println(" enter The Id");
	boolean result=new StudentDao().deleteStudentById(scanner.nextInt());
	if (result) {
		System.out.println(" Data is deleted Suceessfully");
	} else {
		System.out.println(" Data Not deleted Suceessfully");

	}
}
}
