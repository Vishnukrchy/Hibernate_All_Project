package com.jsp.h_BidrectinalOneTOOneMapping.DAO;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Embeddable;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.jsp.h_BidrectinalOneTOOneMapping.DTO.Aadhar;
import com.jsp.h_BidrectinalOneTOOneMapping.DTO.Person;

public class PersonAadharDao {
	// Global EntityManagerFactory
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Vishnu");
	// Global EntityManager
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	// Global EntityTransaction
	EntityTransaction entityTransaction = entityManager.getTransaction();

	// Take return type Person because Person is the main object on which Aadhar is
	// dependent
	public Person save_personAdharDao(Person person, Aadhar aadhar) {
		try {
			entityTransaction.begin();
			person.setAadhar(aadhar);
			aadhar.setPerson(person);

			entityManager.persist(person);

			entityTransaction.commit();
			return person;
		} catch (Exception e) {
			e.printStackTrace();
			if (entityTransaction.isActive()) {
				entityTransaction.rollback();
			}
			return null;
		}
	}

	public Person getPesonAdharDetailsByPersonId(int personId) {
		// To Find With Primary Key
		return entityManager.find(Person.class, personId);
	}

	public Aadhar getPesonAdharDetailsByAdharDetails(long adharId) {
		// To Find With Primary Key
		return entityManager.find(Aadhar.class,  adharId);
	}

	public boolean deletePesonByAdharID(long adharId) {
		String selectQry = "Select p From Person p Where p.aadhar.aadharNo=?1";
		Query query = entityManager.createQuery(selectQry);
		Person person = (Person) query.setParameter(1, adharId).getSingleResult();
		;
		try {
			if (person != null) {
				entityTransaction.begin();
				entityManager.remove(person);
				entityTransaction.commit();
			}
			return true;

		} catch (Exception e) {
			e.printStackTrace();
			return false;
			// TODO: handle exception
		}
	}

}
