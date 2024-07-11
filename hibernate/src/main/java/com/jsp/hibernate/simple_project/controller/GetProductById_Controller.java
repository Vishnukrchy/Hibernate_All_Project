package com.jsp.hibernate.simple_project.controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.jsp.hibernate.simple_project.dto.Procduct;

public class GetProductById_Controller {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Vishnu");
		// Method chaining
		// EntityManagerFactory emf1 =
		// Persistence.createEntityManagerFactory("Vishnu").createEntityManager();
		EntityManager em = emf.createEntityManager();

		Procduct result = em.find(Procduct.class, 101);
		if (result != null) {
			System.out.println(result);
		} else {
			System.out.println(" Data is Not Found");
		}
	}
}
