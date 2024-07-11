package com.jsp.hibernate_OneToMany_Controller;

import com.jsp.hibernate_OneToMany_Dao.StudentTrainerDao;
import com.jsp.hibernate_OneToMany_dto.Trainer;

public class GetTrainerStudentBy_trainer_id {
public static void main(String[] args) {
	Trainer trainer=new StudentTrainerDao().getTrainerStudentByTrainerIdDao(101);
	System.out.println(trainer);
	
}
}
