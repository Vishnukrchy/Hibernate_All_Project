package com.jsp.hibernateManyToOne.Controller;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import com.jsp.hibernateManyToOne.DAO.CollegeUniversity_DAO;
import com.jsp.hibernateManyToOne.DTO.College;
import com.jsp.hibernateManyToOne.DTO.University;

public class InsertCollegeUniversity {
	public static void main(String[] args) {
		University university = new University(201, "BEU", "Patna", "UGC");

		College college1 = new College(101, "IIT-SCE", "Supaul", "Eng.", university);
		College college2 = new College(102, "IIT-PCE", "Purnea", "Eng.", university);
		College college3 = new College(103, "IIT-MCE", "Motihari", "Eng.", university);
		College college4 = new College(104, "IIT-BCE", "Banka", "Eng.", university);
		College college5 = new College(105, "IIT-NCE", "Nalanda", "Eng.", university);
		// College List
		List<College> collegeList = new LinkedList<College>(
				Arrays.asList(college1, college2, college3, college4, college5));

		boolean result = new CollegeUniversity_DAO().saveCollegeAndUniversity(collegeList);
		if (result) {
			System.out.println(" Data is Inserted");
		} else {
			System.out.println(" Data Not Inserted");

		}
	}
}
