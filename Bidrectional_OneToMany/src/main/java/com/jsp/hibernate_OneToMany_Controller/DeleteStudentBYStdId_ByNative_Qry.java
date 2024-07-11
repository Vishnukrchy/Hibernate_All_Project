package com.jsp.hibernate_OneToMany_Controller;

import com.jsp.hibernate_OneToMany_Dao.StudentTrainerDao;

public class DeleteStudentBYStdId_ByNative_Qry {
public static void main(String[] args) {
	boolean result=new StudentTrainerDao().deletedStudentBySdtId_Native_Query_Dao_2(202);
	if (result ) {
		System.out.println(" Data is Deleted");
	} else {
		System.out.println(" Data Not not deletd");

	}
}
}
