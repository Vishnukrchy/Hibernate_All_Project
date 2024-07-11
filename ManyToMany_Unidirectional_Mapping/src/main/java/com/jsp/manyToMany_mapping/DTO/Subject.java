package com.jsp.manyToMany_mapping.DTO;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Subject {
	@Id
	private int id;
	private String name;
	private String authorName;
	private LocalDate publishYear;
	private double price;
}
