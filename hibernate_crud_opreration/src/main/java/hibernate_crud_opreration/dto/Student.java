package hibernate_crud_opreration.dto;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
	@Id
	private int id;
	private String name;
	private String email;
	@CreationTimestamp // To Save current Date And Time Aoutomatically
	private LocalDate registerDate;

	public Student(int id, String name, String email, long phone) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.phone = phone;
	}

	private long phone;

}
