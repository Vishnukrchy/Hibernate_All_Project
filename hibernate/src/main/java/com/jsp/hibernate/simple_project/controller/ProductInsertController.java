package com.jsp.hibernate.simple_project.controller;

import java.time.LocalDate;
import java.util.Scanner;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jsp.hibernate.simple_project.dto.Procduct;

public class ProductInsertController {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Vishnu");
		EntityManager em = emf.createEntityManager();

		EntityTransaction et = em.getTransaction();
		int input;

		do {
			System.out.println(" Enter the Id");
			int id = scanner.nextInt();
			System.out.println(" Enter the name");
			String name = scanner.next();
			System.out.println(" Enter the color");
			String color = scanner.next();
			System.out.println(" Enter the MFD");
			String mfd = scanner.next();
			LocalDate mfdDate = LocalDate.parse(mfd);
			System.out.println(" Enter the EXD");
			String exd = scanner.next();
			LocalDate exddDate = LocalDate.parse(mfd);

			System.out.println(" Enter the Price");
			double price = scanner.nextDouble();
			Procduct product=new Procduct(id, name, color, mfdDate, exddDate, price);
			et.begin();
			// Pesist are used to insert the dats into table
			em.persist(product);
			// to save
			et.commit();
			
			System.out.println("=========  Do You Want Add  more data For press 0 else any digit ");
			 input=scanner.nextInt();
		} while (input != 0);

	
	}
}
