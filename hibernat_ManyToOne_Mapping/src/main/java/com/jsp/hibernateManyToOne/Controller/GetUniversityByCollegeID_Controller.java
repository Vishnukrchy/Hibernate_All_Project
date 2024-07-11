package com.jsp.hibernateManyToOne.Controller;

import com.jsp.hibernateManyToOne.DAO.CollegeUniversity_DAO;
import com.jsp.hibernateManyToOne.DTO.University;

public class GetUniversityByCollegeID_Controller {
	public static void main(String[] args) {
		University university = new CollegeUniversity_DAO().getUniversityBycollegeID(104);
		System.out.println(university);
	}
}
