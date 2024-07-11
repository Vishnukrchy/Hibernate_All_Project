package com.jsp.hibernate.simple_project.controller;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jsp.hibernate.simple_project.dto.Procduct;

public class UpdateProduct {
public static void main(String[] args) {
	Scanner scanner = new Scanner(System.in);
	EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("Vishnu");
	EntityManager entityManager=entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction=entityManager.getTransaction();
	System.out.println(" Enter The Id");
	Procduct resultProcduct=entityManager.find(Procduct.class,scanner.nextInt() );
	
	if (resultProcduct!=null) {
		resultProcduct.setPrice(10000);
		resultProcduct.setColor(" skyBlue");
		// start transaction
		entityTransaction.begin();
		// merge the updated record
		entityManager.merge(resultProcduct);
		// save it 
		entityTransaction.commit();
	} else {

	}
}
}
