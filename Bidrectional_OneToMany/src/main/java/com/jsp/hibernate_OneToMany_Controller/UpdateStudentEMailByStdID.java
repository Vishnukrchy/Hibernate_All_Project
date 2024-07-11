package com.jsp.hibernate_OneToMany_Controller;

import com.jsp.hibernate_OneToMany_Dao.StudentTrainerDao;

public class UpdateStudentEMailByStdID {
	public static void main(String[] args) {
     boolean result=new StudentTrainerDao().updateStudentEmailByStudentID(201,"sanu@gmail.com");
     System.out.println(result?"Data is Updated":"Data is Not Updated");
	}
}
