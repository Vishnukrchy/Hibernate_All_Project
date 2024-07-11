package com.jsp.hibernate_OneToMany_Controller;

import java.util.List;

import com.jsp.hibernate_OneToMany_Dao.StudentTrainerDao;
import com.jsp.hibernate_OneToMany_dto.Trainer;

public class GatAllTrainerDetails {
	public static void main(String[] args) {
//		List<Trainer> trainerList = new StudentTrainerDao().getAllTrainerStudentdao();
//		// Print All Trainer details
//		for (Trainer trainer : trainerList) {
//			System.out.println(trainer);
//		}
		
		// Lamda Exprestion;
		
		List<Trainer> trainers=new StudentTrainerDao().getAllTrainerStudentByTrainerId_1_Dao();
		trainers.forEach(a->System.out.println(a));

	}
}
