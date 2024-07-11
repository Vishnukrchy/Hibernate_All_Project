package hibrenate_one_to_one_mapping.Controller;

import java.util.Scanner;

import hibrenate_one_to_one_mapping.dao.PersonAadharDao;

public class AdharDeleteByPersonId_Controller {
	public static void main(String[] args) {
		Scanner scanner =new Scanner(System.in);
		System.out.println(" Enter The Pesson ID");
      boolean result=new PersonAadharDao(). adharDeleteByPersonIdDao(scanner.nextInt());
      
      if (result) {
		System.out.println(" Adhar Details Is Deleted Suceesfully");
	} else {
		System.out.println(" Adhar Details Not Deleted ");

	}
	}
}
