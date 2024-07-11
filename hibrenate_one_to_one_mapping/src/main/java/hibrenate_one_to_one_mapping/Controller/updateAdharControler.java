package hibrenate_one_to_one_mapping.Controller;

import java.time.LocalDate;

import hibrenate_one_to_one_mapping.dao.PersonAadharDao;

public class updateAdharControler {
public static void main(String[] args) {
	boolean res=new PersonAadharDao().updateDobAdharByPerson(56543235, LocalDate.parse("2193-09-09"));
	
	if (res) {
		System.out.println(" Adhar is upadetd");
	} else {
		System.out.println(" Adhar not  upadetd");

	}
}
}
