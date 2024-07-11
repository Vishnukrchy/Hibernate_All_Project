package hibrenate_one_to_one_mapping.Controller;

import java.util.Scanner;

import hibrenate_one_to_one_mapping.dao.PersonAadharDao;

public class PesonDeletreController {
	public static void main(String[] args) {
		Scanner scanner =new Scanner(System.in);
		System.out.println(" Enter The Pesson ID");
      boolean result=new PersonAadharDao().personDeleteByIdDao(scanner.nextInt());
      
      if (result) {
		System.out.println(" Person Details Is Deleted Suceesfully");
	} else {
		System.out.println(" Person Details Not Deleted ");

	}
	}
}
