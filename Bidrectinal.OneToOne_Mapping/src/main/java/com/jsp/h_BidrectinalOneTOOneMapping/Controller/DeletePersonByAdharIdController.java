package com.jsp.h_BidrectinalOneTOOneMapping.Controller;

import com.jsp.h_BidrectinalOneTOOneMapping.DAO.PersonAadharDao;
import com.jsp.h_BidrectinalOneTOOneMapping.DTO.Person;

public class DeletePersonByAdharIdController {
public static void main(String[] args) {
	boolean result=new PersonAadharDao().deletePesonByAdharID(523354);
	System.out.println(result?" Data is Deletd":"data IS Not Deletd");
}
}
