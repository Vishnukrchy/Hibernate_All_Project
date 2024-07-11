package com.jsp.hibernate.simple_project.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.jsp.hibernate.simple_project.dto.Procduct;

public class DisplayAllDetails {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Vishnu");
		EntityManager em = emf.createEntityManager();
		// EntityTransaction et=em.getTransaction(); // No Used this bez there is no database transaction
		// Create JPQL QUERY // from Product Class
		Query query = em.createQuery("from Procduct");
		// Query interface have getResultlist:List method To get data from the table
		List<Procduct> produList = query.getResultList();

		for (Procduct product : produList) {
			System.out.println(product);
		}
	}
}
