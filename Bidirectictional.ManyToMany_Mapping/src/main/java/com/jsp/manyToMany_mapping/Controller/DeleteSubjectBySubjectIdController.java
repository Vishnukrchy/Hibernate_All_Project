package com.jsp.manyToMany_mapping.Controller;

import com.jsp.manyToMany_mapping.DAO.Student_subject_DAO;

public class DeleteSubjectBySubjectIdController {
public static void main(String[] args) {
	boolean result=new Student_subject_DAO().deleteSubjectBySubId(101);
	System.out.println(result?"Data Is Deleted successfully":" Data Is Not Deletd");
}
}
