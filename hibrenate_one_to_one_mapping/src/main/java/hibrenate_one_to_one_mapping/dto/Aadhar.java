package hibrenate_one_to_one_mapping.dto;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Aadhar {
	// id is primaryKey In Aadhar table
	@Id
private long aadharNo;
private  LocalDate dob;
private  String address;
private String fatherName;


}
