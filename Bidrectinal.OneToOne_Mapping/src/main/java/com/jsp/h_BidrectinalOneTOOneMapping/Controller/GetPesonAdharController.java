package com.jsp.h_BidrectinalOneTOOneMapping.Controller;

import com.jsp.h_BidrectinalOneTOOneMapping.DAO.PersonAadharDao;
import com.jsp.h_BidrectinalOneTOOneMapping.DTO.Person;

public class GetPesonAdharController {
	public static void main(String[] args) {
		Person person = new PersonAadharDao().getPesonAdharDetailsByPersonId(109);

		System.out.println(person);
		System.out.println(person.getAadhar());

	}
}
