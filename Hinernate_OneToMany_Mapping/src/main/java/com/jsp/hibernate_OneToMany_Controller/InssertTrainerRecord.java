package com.jsp.hibernate_OneToMany_Controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.jsp.hibernate_OneToMany_Dao.StudentTrainerDao;
import com.jsp.hibernate_OneToMany_dto.Student;
import com.jsp.hibernate_OneToMany_dto.Trainer;

public class InssertTrainerRecord {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		List<Student> stList = new ArrayList<Student>();
//		stList.add(new Student(201, "das", "das@gmail.com", LocalDate.parse("3090-09-09")));
//		stList.add(new Student(202, "sas", "sas@gmail.com", LocalDate.parse("3091-09-09")));
//		stList.add(new Student(203, "nas", "nas@gmail.com", LocalDate.parse("3092-09-09")));
//		stList.add(new Student(204, "kas", "kas@gmail.com", LocalDate.parse("3093-09-09")));
		int con = 1;
		do {
			System.out.println(" Enter The Student Id");
			int id = scanner.nextInt();
			System.out.println(" Enter The Student name");
			String name = scanner.next();
			System.out.println(" Enter The Student email");
			String email = scanner.next();
			System.out.println(" Enter The Student DOB");
			LocalDate dob = LocalDate.parse(scanner.next());
			// Added Student in list
			stList.add(new Student(id, name, email, dob));
			System.out.println("==== Enter The Choice ===========");
			System.out.println(" Press =>1 for add More Record  ============");
			System.out.println(" Press =>0  for  ============");

		} while (con == scanner.nextInt());

		Trainer trainer = new Trainer(102, "nikhil", "nikhil@gmai.com", 4355, LocalDate.parse("2050-09-09"), "AI-ML",
				stList);
		/*if casdede is not used
		Trainer result = new StudentTrainerDao().saveTrainerDao(trainer, stList);
		*/
		// if cascade id used then we need only one parameters
		 
		Trainer result=new StudentTrainerDao().saveTrainerCascadeDao(trainer);
		

		if (result != null) {
			System.out.println(" Data is Inserted");
		} else {
			System.out.println(" Data Not Inserted");

		}
	}
}
