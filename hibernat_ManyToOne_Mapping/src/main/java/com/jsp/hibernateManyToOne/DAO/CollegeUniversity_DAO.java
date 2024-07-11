package com.jsp.hibernateManyToOne.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jsp.hibernateManyToOne.DTO.College;
import com.jsp.hibernateManyToOne.DTO.University;

public class CollegeUniversity_DAO {
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("Vishnu");
	EntityManager em = emf.createEntityManager();
	EntityTransaction et = em.getTransaction();

	// Save College Details
	// Multiple college Have Same University;
	public boolean saveCollegeAndUniversity(List<College> collegeList) {
		try {
			for (College college : collegeList) {
				et.begin();
				em.persist(college);
				et.commit();
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

//Cannot delete or update a parent row: a foreign key constraint fails
	public boolean deleteCollegeByCollegeId(int collogeID) {
		College college = em.find(College.class, collogeID);
		try {

			if (college != null) {
				et.begin();
			
				em.remove(college);
				et.commit();
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return true;

		}
	}

	// worked
	public List<College> getAllCollegeAndUniveraityDAO() {
		return em.createQuery("From College").getResultList();
	}

	public University getUniversityBycollegeID(int collegeId) {
		College college = em.find(College.class, collegeId);
		if (college != null) {
			try {
				University university = college.getUniversity();
				return university;
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}

		} else {
			System.out.println(" College is  not found");
			return null;
		}

	}

// not worked 
	public boolean deleteUniversityByUniversityID_DAO(int universityID) {
		University university = em.find(University.class, universityID);
		try {
			if (university != null) {
				et.begin();
				em.remove(university);
				et.commit();
			}
			return true;

		} catch (Exception e) {
			e.printStackTrace();
			return true;

		}
	}
	// not worked
	public boolean updateCollegeByCollegeId(int collegeId,int uId) {
		College college=em.find(College.class, collegeId);
		if (college!=null) {
			try {
				et.begin();
//				college.setUniversity(uId);
				
				
				em.merge(college);
				et.commit();
				return true;
			} catch (Exception e) {
				e.printStackTrace();
				return true;
				
			}
		}
		else {
			System.out.println(" Data is Not Found !!!");
			return false;
		}
		
	}
}
