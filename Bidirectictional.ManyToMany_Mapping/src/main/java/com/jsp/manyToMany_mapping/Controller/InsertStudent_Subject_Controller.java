package com.jsp.manyToMany_mapping.Controller;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import com.jsp.manyToMany_mapping.DAO.Student_subject_DAO;
import com.jsp.manyToMany_mapping.DTO.Student;
import com.jsp.manyToMany_mapping.DTO.Subject;

public class InsertStudent_Subject_Controller {
	public static void main(String[] args) {
		Subject sub1 = new Subject(101, "Java", "James Gosling", LocalDate.parse("1995-09-09"), 250, null);
		Subject sub2 = new Subject(102, "SQL", "Thames", LocalDate.parse("1993-09-09"), 250, null);
		Subject sub3 = new Subject(103, "HTML", "Tim", LocalDate.parse("1994-09-09"), 150, null);
		Subject sub4 = new Subject(104, "CSS", "Burner", LocalDate.parse("1996-09-09"), 200, null);
		Subject sub5 = new Subject(105, "JS", "Liee", LocalDate.parse("1999-09-09"), 150, null);

		// Subject List
		List<Subject> subList = new LinkedList<Subject>(Arrays.asList(sub1, sub2, sub3, sub4, sub5));

		// Students
		Student student1 = new Student(201, "Rahul", "r@gmail.com", 242342, subList);
		Student student2 = new Student(202, "Mahul", "m@gmail.com", 43342, subList);

//		for (Subject subject : subList) {
//			subject.getStdList().add(student1);
//			subject.getStdList().add(student2);
//		}
		// Student List
		List<Student> stuList = new LinkedList<Student>();
		stuList.add(student1);
		stuList.add(student2);

		List<Student> savedStudents = new Student_subject_DAO().savestudentANdSubjectDao(stuList, subList);
		System.out.println(savedStudents != null ? "Data Saved" : "Data is Not Saved");
	}
}
