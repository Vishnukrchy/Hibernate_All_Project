package com.jsp.hibernate_OneToMany_dto;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Trainer {
	@Id
	private int id;
	private String name;
	@Column(nullable = false,length = 30)
	private String email;
	private long phone_No;
	private LocalDate dob;
	private String specilization;
	@OneToMany(cascade = CascadeType.ALL)
	List<Student> stdnList;

}
