package com.jsp.hibernateManyToOne.Controller;

import com.jsp.hibernateManyToOne.DAO.CollegeUniversity_DAO;

public class UpdateCollegeBYCollegeID {
public static void main(String[] args) {
	boolean result=new CollegeUniversity_DAO().updateCollegeByCollegeId(101, 202);
	System.out.println(result?" Data IS Updated ":" data Is Not Updated");
}
}
