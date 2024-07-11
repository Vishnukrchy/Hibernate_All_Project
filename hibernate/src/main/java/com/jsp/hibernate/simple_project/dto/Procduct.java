package com.jsp.hibernate.simple_project.dto;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Procduct {
	@Id
	private int id;
	private String name;
	private String color;
	private LocalDate mfd;
	private LocalDate expt;
	private double price;

	
}
