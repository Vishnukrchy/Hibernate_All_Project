package com.jsp.h_BidrectinalOneTOOneMapping.DTO;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
//@Data  dont need to string method
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Person {

	// Id Is Primary key In Person Table
	@Id
	private int id;
	private String name;
	private String email;
	private long phone_No;

	@OneToOne(cascade = CascadeType.ALL) // to Crud the dependent object that aasoiaated with indendent object
	@JoinColumn(name = "AdharNumber") // to change joint column name
	private Aadhar aadhar;

	public Person(int id, String name, String email, long phone_No) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.phone_No = phone_No;
	}
	// here we are using To string method insteed of @Data because if we print details of aadhar in Person class to string method 
	// and peson detsils in Aadhar class tostrining its give error stackOverflow 
	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", email=" + email + ", phone_No=" + phone_No 
				+ "]";
	}
	

}
