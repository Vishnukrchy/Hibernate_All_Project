package com.jsp.hibernateManyToOne.DTO;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity @Data@NoArgsConstructor@AllArgsConstructor

public class University {
	@Id
	private int id;
	private String name;
	private String address;
	private String affilation;
	// One University Can have Multiple college
}
