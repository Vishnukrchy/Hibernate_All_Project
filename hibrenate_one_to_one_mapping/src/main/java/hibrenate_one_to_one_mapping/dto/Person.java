package hibrenate_one_to_one_mapping.dto;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Person {
	
	// Id Is Primary key In Person Table
	@Id
	private int id;
	private String name;
	private String email;
	private long phone_No;

	@OneToOne // To Mak
	//@OneToOne(cascade = CascadeType.REMOVE)// to deleete the dependent object that aasoiaated with indendent object
	(cascade = CascadeType.ALL)// to Crud the dependent object that aasoiaated with indendent object
	//@OneToOne(cascade = {CascadeType.PERSIST,CascadeType.MERGE})// to pesist,merge,... the dependent object that aasoiaated with indendent object
	@JoinColumn(name="AdharName") // to change joint column name
	Aadhar aadhar;

	public Person(int id, String name, String email, long phone_No) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.phone_No = phone_No;
	}
	
}
