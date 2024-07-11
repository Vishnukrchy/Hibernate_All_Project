package com.jsp.hibernateManyToOne.Controller;

import com.jsp.hibernateManyToOne.DAO.CollegeUniversity_DAO;

public class DeleteUniversityBy_UniversityID {
public static void main(String[] args) {
	boolean result=new CollegeUniversity_DAO().deleteUniversityByUniversityID_DAO(201);
	System.out.println(result?"Data  is Deletd":" Data Is Not Deleted");
	
}
}
