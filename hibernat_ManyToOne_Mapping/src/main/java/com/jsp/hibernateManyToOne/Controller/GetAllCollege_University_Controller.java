package com.jsp.hibernateManyToOne.Controller;

import java.util.List;

import com.jsp.hibernateManyToOne.DAO.CollegeUniversity_DAO;
import com.jsp.hibernateManyToOne.DTO.College;

public class GetAllCollege_University_Controller {
public static void main(String[] args) {
	List<College> colleges=new CollegeUniversity_DAO().getAllCollegeAndUniveraityDAO();
	colleges.forEach(college->System.out.println(college));
	
}
}
