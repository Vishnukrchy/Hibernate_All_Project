package hibrenate_one_to_one_mapping.Controller;

import java.time.LocalDate;

import hibrenate_one_to_one_mapping.dao.PersonAadharDao;
import hibrenate_one_to_one_mapping.dto.Aadhar;
import hibrenate_one_to_one_mapping.dto.Person;

public class InsertPesron_Aadhar_controller {
	public static void main(String[] args) {
		Aadhar aadhar = new Aadhar(523354, LocalDate.parse("2000-03-02"), "Moida", "sam Lal");
		// For Cassading all  we can insert the adhar record by constructor or person.setAadhar(aadhar)
		//Person person = new Person(102, "sohan", "sohan@gmail.com", 565432435, aadhar);
		Person person = new Person(109, "dsohan", "dosdhan@gmail.com", 565432435 );

		PersonAadharDao personAadharDao = new PersonAadharDao();
		personAadharDao.save_personAdharDao(person, aadhar);
		
	}
}
