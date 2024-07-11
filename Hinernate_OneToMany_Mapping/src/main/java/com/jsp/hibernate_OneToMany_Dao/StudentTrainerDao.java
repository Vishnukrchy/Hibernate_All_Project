package com.jsp.hibernate_OneToMany_Dao;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.jsp.hibernate_OneToMany_dto.Student;
import com.jsp.hibernate_OneToMany_dto.Trainer;

public class StudentTrainerDao {
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("Vishnu");
	EntityManager em = emf.createEntityManager();
	EntityTransaction et = em.getTransaction();

// If  cascade is not used then we need to save the dependent object(student) 
	// in which we can set student details by setters mathod or constructor
	public Trainer saveTrainerDao(Trainer trainer, List<Student> stList) {

		try {
			et.begin();
			for (Student student : stList) {
				em.persist(student);
			}
			em.persist(trainer);
			et.commit();

			return trainer;

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}

	}

	// If cascade is not used then we need to save the dependent object(student)
	public Trainer saveTrainerCascadeDao(Trainer trainer) {

		try {
			et.begin();
			em.persist(trainer);
			et.commit();

			return trainer;

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}

	}

	public boolean deleteBYId(int tarinerId) {
		Trainer trainer = em.find(Trainer.class, tarinerId);
		if (trainer != null) {
			trainer.setId(tarinerId);
			et.begin();
			em.remove(trainer);
			et.commit();
			return true;
		} else {
			System.out.println(" Student is not found");
			return false;
		}
	}

// gpt code  in which we comunicate with class intity not
	public boolean deletedStudentBySdtIdDao_1(int studentId) {
		Student student = em.find(Student.class, studentId);
		if (student != null) {
			et.begin();
			// Find all trainers that reference this student and remove the reference
			List<Trainer> trainers = em
					.createQuery("SELECT t FROM Trainer t JOIN t.stdnList s WHERE s.id = :studentId", Trainer.class)
					.setParameter("studentId", studentId).getResultList();
			for (Trainer trainer : trainers) {
				trainer.getStdnList().remove(student);
				em.merge(trainer);
			}
			em.remove(student);
			et.commit();
			return true;
		} else {
			System.out.println("Student is not found");
			return false;
		}
	}

	/*We can Not directly delete the trainer Details by First We have to make relationship(Foreign Key) null between Two table
	 * To Remove Association we have to find the trainer details to null
	 * association Create Delete native Query and and execute the by
	 * EcexecuteUpdate method
	 *  class Code
	 * 
	 */
	public boolean deletedStudentBySdtId_Native_Query_Dao_2(int studentId) {
		Student student = em.find(Student.class, studentId);
		if (student != null) {
			// String deleteNativeQey="Delete From trainer_student where stdnList_id=?";
			String deleteNativeQey = "Delete From trainer_student where stdnList_id=?1";
			Query nativeQuery = em.createNativeQuery(deleteNativeQey);
			// nativeQuery.setParameter(studentId, nativeQuery);
			nativeQuery.setParameter(1, studentId);

			try {
				et.begin();
				// To Run the native Quey we have Method ececuteUpdate() its return integre
				// Value
				int a = nativeQuery.executeUpdate();
				em.remove(student);
				et.commit();
				return true;
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				System.out.println(" Details Is Not Found");
				return false;
			}
		} else {
			System.out.println(" student details Is Not found !!");
			return false;
		}
	}
// my Code
//	public boolean  deleteStudentByStudentId_DAO_3(int studentId) {
//		String select="Select t from Trainer t Where t."
//	}
//  get Trainer_Student  By trainer Id 
	public Trainer getTrainerStudentByTrainerIdDao(int trainerIId) {
		Query query = em.createQuery("from Trainer");
		// take Trainer List from The trainer table By JPQL Qry
		List<Trainer> trainer = query.getResultList();
		//
		for (Trainer trainer2 : trainer) {
			return trainer2;
		}
		return null;

	}

//  get Trainer_Student  By trainer Id 
	public Trainer getTrainerStudentByTrainerId_1_Dao(int trainerIId) {
		// Find The Trainer Detials By Trainer ID Ad Retrun This
		return em.find(Trainer.class, trainerIId);

	}
    // Get All Trainer Details 
	public List<Trainer> getAllTrainerStudentdao() {
		// Create The JPQL Query to get the all details from trainer Table and store
		// into list
		Query query = em.createQuery("from Trainer");
		List<Trainer> trainer = query.getResultList();
		return trainer;
	}
	 // Get All Trainer Details 
	public List<Trainer> getAllTrainerStudentByTrainerId_1_Dao() {
		// Find The TrainerList By JPQL Qry Retrun This
		return em.createQuery("from Trainer").getResultList();

	}

}
