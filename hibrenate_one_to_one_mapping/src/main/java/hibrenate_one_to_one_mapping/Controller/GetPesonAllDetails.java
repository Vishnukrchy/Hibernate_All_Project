package hibrenate_one_to_one_mapping.Controller;

import java.util.List;

import hibrenate_one_to_one_mapping.dao.PersonAadharDao;
import hibrenate_one_to_one_mapping.dto.Person;

public class GetPesonAllDetails {
	public static void main(String[] args) {
		List<Person> perList = new PersonAadharDao().getAllPersonDetails();
		for (Person person : perList) {
			System.out.println(person);
		}
	}
}
