package controller;

import hibernate_crud_opreration.dao.StudentDao;
import hibernate_crud_opreration.dto.Student;

public class InsertController {
public static void main(String[] args) {
	Student student =new Student(103,"chamm", "chn@gmail.com", 7348226);
	StudentDao studentDao=new StudentDao();
	studentDao.insertStudentDao(student);
}
}
