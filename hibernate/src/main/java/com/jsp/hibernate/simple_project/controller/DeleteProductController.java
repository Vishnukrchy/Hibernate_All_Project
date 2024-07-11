package com.jsp.hibernate.simple_project.controller;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jsp.hibernate.simple_project.dto.Procduct;

public class DeleteProductController {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Vishnu");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		// Here WE ARE GOING TO DELETE TEH DETAILS MEANS TRANSACTION WILL HAPEND WITH
		// DATABASE
		// DML COMMAND WILL EXEQUETES SO WE NEED getTransaction() METHOD
		EntityTransaction entityTransaction = entityManager.getTransaction();

		// before going to delete the product detail;s we have to fined that product
		// with the helped of find(Object,key):Object:EntityManger
		// for DQL we need enttityMannger refernce
		System.out.println(" Enter The Id");
		Procduct resultProcduct = entityManager.find(Procduct.class, scanner.nextInt());

		if (resultProcduct != null) {
			entityTransaction.begin();
			// Remove method Have Entity Manager
			entityManager.remove(resultProcduct);
			entityTransaction.commit();
		} else {
System.out.println(" data is Not Found !!!");
		}

	}
}
