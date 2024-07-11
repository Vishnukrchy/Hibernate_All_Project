package com.jsp.hibernate_OneToMany_dto;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
//@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Student {
	@Id
	private int id;
	private String name;
	private String email;
	private LocalDate dob;
	// Multiple student Can HavE one Trainer So Have Trainer IS Dependent Object
	@ManyToOne(cascade = CascadeType.ALL )
	private Trainer trainer;
}
