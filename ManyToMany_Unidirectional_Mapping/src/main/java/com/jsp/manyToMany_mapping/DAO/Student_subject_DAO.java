package com.jsp.manyToMany_mapping.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jsp.manyToMany_mapping.DTO.Student;
import com.jsp.manyToMany_mapping.DTO.Subject;

public class Student_subject_DAO {
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Vishnu");
	EntityManager emEntityManager = entityManagerFactory.createEntityManager();
	EntityTransaction et = emEntityManager.getTransaction();
// 
	public List<Student> savestudentANdSubjectDao(List<Student> stuList) {
		try {
			et.begin();
			for (Student student : stuList) {
				emEntityManager.persist(student);
			}
			et.commit();
			return stuList;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	public boolean deleteSubjectBySubId(int subjectId) {
		Subject subject = emEntityManager.find(Subject.class, subjectId);
		try {
			if (subject != null) {
				et.begin();
				// communicate With thrid table drectky with the helped of nativeQuery so we can
				// Deleted
				// the Assosiation
				// method chaning of native query
				emEntityManager.createNativeQuery("Delete From student_subject where subList_id=?1 ")
						.setParameter(1, subjectId).executeUpdate();
				// remove the subject
				emEntityManager.remove(subject);
				et.commit();

			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}
   // get All Details 
	public List<Student> getAllStudentAndSubjectDao() {
          return emEntityManager.createQuery("From Student").getResultList();
	}
	

}
