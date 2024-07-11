package hibrenate_one_to_one_mapping.dao;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import hibrenate_one_to_one_mapping.dto.Aadhar;
import hibrenate_one_to_one_mapping.dto.Person;

public class PersonAadharDao {
    // Global EntityManagerFactory
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Vishnu");
    // Global EntityManager
    EntityManager entityManager = entityManagerFactory.createEntityManager();
    // Global EntityTransaction
    EntityTransaction entityTransaction = entityManager.getTransaction();

    // Take return type Person because Person is the main object on which Aadhar is dependent
    public Person save_personAdharDao(Person person, Aadhar aadhar) {
        try {
            entityTransaction.begin();
            // entityManager.persist(aadhar); Not needed when cascaded in dependent object
            // person will automatically save it
            // if Aadhar is null passed in person constructor
            person.setAadhar(aadhar);
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

    // Delete Person by ID
    public boolean personDeleteByIdDao(int personId) {
        // Here JPQL query is not used because we can find the details with primary key
        Person person = entityManager.find(Person.class, personId);
        if (person != null) {
            entityTransaction.begin();
            entityManager.remove(person);
            entityTransaction.commit();
            return true;
        } else {
            System.out.println("Person details not found");
            return false;
        }
    }

    // We cannot directly delete Aadhar details because it's dependent on Person object
    public boolean adharDeleteByPersonIdDao(int personId) {
        Person person = getPersonDetailsByID(personId);
        if (person != null) {
            entityTransaction.begin();
            Aadhar aadhar = person.getAadhar();
            person.setAadhar(null);
            entityManager.merge(person);
            entityTransaction.commit();

            if (aadhar != null) {
                entityTransaction.begin();
                entityManager.remove(aadhar);
                entityTransaction.commit();
                return true;
            } else {
                System.out.println("Aadhar details not found");
                return false;
            }
        } else {
            System.out.println("Person details not found");
            return false;
        }
    }

    // Get Person details by ID
    public Person getPersonDetailsByID(int personId) {
        return entityManager.find(Person.class, personId);
    }

    // Update DOB in Aadhar by Person's phone number
    public boolean updateDobAdharByPerson(long phoneNo, LocalDate dob) {
        Person person = getPersonByPhone(phoneNo);

        if (person != null) {
            Aadhar aadhar = person.getAadhar();
            aadhar.setDob(dob);
            entityTransaction.begin();
            entityManager.merge(aadhar);
            entityTransaction.commit();
            return true;
        } else {
            System.out.println("Person details not found");
            return false;
        }
    }

    // Get Person by phone number
    public Person getPersonByPhone(long phoneNo) {
        try {
            // JPQL query
            String selectQuery = "SELECT p FROM Person p WHERE p.phone_No = ?1";
            Query query = entityManager.createQuery(selectQuery);
            query.setParameter(1, phoneNo);
            return (Person) query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    // Get Person All Details( We Can Get The JPQL Query)
    public List<Person> getAllPersonDetails() {
    	// JQPL Query
    	Query query=entityManager.createQuery("from Person");
    	List<Person> personList=query.getResultList();
    	return personList;
		
	}
}
