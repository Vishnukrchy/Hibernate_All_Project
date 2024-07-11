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

		Trainer trainer = new Trainer(102, "nikhil", "nikhil@gmai.com", 4355, LocalDate.parse("2050-09-09"), "AI-ML",
				null);

		List<Student> stList = new ArrayList<Student>();
		stList.add(new Student(201, "das", "das@gmail.com", LocalDate.parse("3090-09-09"), trainer));
		stList.add(new Student(202, "sas", "sas@gmail.com", LocalDate.parse("3091-09-09"), trainer));
		stList.add(new Student(203, "nas", "nas@gmail.com", LocalDate.parse("3092-09-09"), trainer));
		stList.add(new Student(204, "kas", "kas@gmail.com", LocalDate.parse("3093-09-09"), trainer));

		// Arrays.asList(s1,s2 ,...);

		List<Student> stdList = new StudentTrainerDao().saveStudentTrainerDao(stList);

		if (stdList != null) {
			System.out.println(" Data is Inserted");
		} else {
			System.out.println(" Data Not Inserted");

		}
	}
}
