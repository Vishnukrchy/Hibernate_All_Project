package controller;

import hibernate_crud_opreration.dao.StudentDao;
import hibernate_crud_opreration.dto.Student;
import hibernate_crud_opreration.exception.IdNotFondExeption;

public class GetStudentById {
	public static void main(String[] args) {
		System.out.println(" Enter The Id");
		Student student = new StudentDao().getStudentByIdDao(101);
		if (student != null) {
			System.out.println(student);

		} else {
			try {
				throw new IdNotFondExeption(" Id Is Not Found");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
