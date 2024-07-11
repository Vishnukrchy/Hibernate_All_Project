package com.jsp.manyToMany_mapping.DTO;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
	@Id
	private int id;
	private String name;
	private String email;
	private long phone;

	@JoinTable(
			// This Is For The Third Table Name
			name = "studentSubject",

			joinColumns = {
					// This Is For The independent Object column name in Third Table
					@JoinColumn(name = "studentID"), },

			inverseJoinColumns = {
					// This is for object or foreign key column name in third table
					@JoinColumn(name = "subjectId") }) // @joinColumn To Change The Name Of Third Table Column We need
														// @jointColumn

	@ManyToMany(cascade = CascadeType.ALL)

	List<Subject> subList;
}
