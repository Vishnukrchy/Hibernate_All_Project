package com.jsp.h_BidrectinalOneTOOneMapping.Controller;

import com.jsp.h_BidrectinalOneTOOneMapping.DAO.PersonAadharDao;
import com.jsp.h_BidrectinalOneTOOneMapping.DTO.Aadhar;
import com.jsp.h_BidrectinalOneTOOneMapping.DTO.Person;

public class GetPesonAharDetailsByAdharNo {
public static void main(String[] args) {
	Aadhar pAadhar = new PersonAadharDao().getPesonAdharDetailsByAdharDetails(103354);
   // Here We are not getting person detais in Aadhar toString Method  person is not mention
	System.out.println(pAadhar);
	
}
}
