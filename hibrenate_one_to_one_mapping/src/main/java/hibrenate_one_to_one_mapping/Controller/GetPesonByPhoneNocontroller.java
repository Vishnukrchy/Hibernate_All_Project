package hibrenate_one_to_one_mapping.Controller;

import hibrenate_one_to_one_mapping.dao.PersonAadharDao;
import hibrenate_one_to_one_mapping.dto.Person;

public class GetPesonByPhoneNocontroller {
	public static void main(String[] args) {
Person person=new PersonAadharDao().getPersonByPhone(56543235);
System.out.println(person);
	}
}
