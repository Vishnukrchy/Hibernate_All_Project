package hibernate_crud_opreration.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.mysql.cj.Query;

import hibernate_crud_opreration.dto.Student;

public class StudentDao {
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("Vishnu");
	EntityManager em = emf.createEntityManager();
	EntityTransaction entityTransaction = em.getTransaction();

	public Student insertStudentDao(Student s) {
//		Student student = new Student(101, "Rahul", "rahul@gmail.com", 24234234);

		try {
			entityTransaction.begin();
			em.persist(s);
			entityTransaction.commit();
			return s;
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}

///  This is For The STudent 
	public Student getStudentByIdDao(int studentId) {
		return em.find(Student.class, studentId);
	}

	public Student getStudentBYNameDao(String name) {
		// JPQL Query
		String selectQuery = "SELECT s FROM STUDENT s Where s.name=?1";
		javax.persistence.Query query = em.createQuery("selectQuery");

		query.setParameter(1, query);

		return (Student) query.getSingleResult();

	}

	public List<Student> getAllStudent() {
		javax.persistence.Query query = em.createQuery("from Student");
		List<Student> stList = query.getResultList();
		return stList;
	}

	public boolean deleteStudentById(int studentId) {
		Student student = em.find(Student.class, studentId);
		if (student != null) {
			student.setId(studentId);
			entityTransaction.begin();
			em.remove(student);
			entityTransaction.commit();
			return true;
		} else {
			System.out.println(" Student is not found");
			return false;
		}

	}

	public Student updateStudentBYId(int id, String name) {
		Student student = em.find(Student.class, id);
		// student.setId(id);
		if (student != null) {

			student.setName(name);
			entityTransaction.begin();
			em.merge(student);
			entityTransaction.commit();
			return student;
		} else {
			System.out.println(" Student is Not Is found");
			return null;
		}

	}
}
