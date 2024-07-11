package com.jsp.h_BidrectinalOneTOOneMapping.Controller;

import java.time.LocalDate;

import com.jsp.h_BidrectinalOneTOOneMapping.DAO.PersonAadharDao;
import com.jsp.h_BidrectinalOneTOOneMapping.DTO.Aadhar;
import com.jsp.h_BidrectinalOneTOOneMapping.DTO.Person;

public class InsertPersonAdhar {
	public static void main(String[] args) {
		// in Bidrectinal we kept both person in adhhar object adhar in Person Object is null 
		// we set this details by setters methods 
		Aadhar aadhar = new Aadhar(103354, LocalDate.parse("2002-02-02"), "Soida", "Aam Lal", null);

		Person person = new Person(102, "dsohan", "dosdhan@gmail.com", 565432435, null);
		
		Person person2=new PersonAadharDao().save_personAdharDao(person, aadhar);
		System.out.println(person2!=null?"Data Is Saved":"Data IS Not saved");
	}

}
