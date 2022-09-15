package ilayda.entities.concretes;

import javax.persistence.*;

import lombok.Data;

@Data
@Entity
@Table (name="jobSeekers") 

public class JobSeeker {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column (name="jobseeker_id")
	private int id;
	
	@Column(name="jobseeker_name")
	private String name;
	
	@Column (name="jobseeker_surname")
	private String surname;
	
	@Column (name="jobseeker_identityno")
	private String identityNo;
	
	@Column (name="jobseeker_birthyear")
	private int birthyear;
	
	@Column (name="jobseeker_mail")
	private String mail;
	
	@Column (name="jobseeker_password")
	private String password;
	
	@Column (name="jobseeker_password2")
	private String password2;

	
	
}
