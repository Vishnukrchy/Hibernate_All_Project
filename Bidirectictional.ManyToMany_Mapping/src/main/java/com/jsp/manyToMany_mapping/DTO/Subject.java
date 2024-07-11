package com.jsp.manyToMany_mapping.DTO;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

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

	@ManyToMany(mappedBy = "subList")
	private List<Student> stdList;
}
