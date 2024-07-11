package com.jsp.h_BidrectinalOneTOOneMapping.DTO;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity

//@Data  dont need to string method
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class Aadhar {
	// id is primaryKey In Aadhar table
	@Id
private long aadharNo;
private  LocalDate dob;
private  String address;
private String fatherName;

@OneToOne(mappedBy = "aadhar") // mappedBy is used to make the person table as owner table
private Person person;
// here we are using To string method insteed of @Data because if we print details of aadhar in Person class to string method 
// and peson detsils in Aadhar class tostrining its give error stackOverflow 
@Override
public String toString() {
	return "Aadhar [aadharNo=" + aadharNo + ", dob=" + dob + ", address=" + address + ", fatherName=" + fatherName
			+"]";
}


}
