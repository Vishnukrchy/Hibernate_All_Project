package com.jsp.hibernateManyToOne.DTO;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity @Data@NoArgsConstructor@AllArgsConstructor
public class College {
	@Id
	private int id;
	private String name;
	private String address;
	private String type;
	
	@ManyToOne
	private University university;

}
