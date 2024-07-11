package com.jsp.hibernateManyToOne.Controller;

import com.jsp.hibernateManyToOne.DAO.CollegeUniversity_DAO;

public class DeeleteCollegeByCollege_Id {
	public static void main(String[] args) {
		boolean result = new CollegeUniversity_DAO().deleteCollegeByCollegeId(104);
		System.out.println(result ? "College Is deletd" : " College Is Not Deleted");
	}
}
