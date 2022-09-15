package ilayda.entities.concretes;

import javax.persistence.*;

import lombok.Data;

@Data
@Entity
@Table (name="employers")
public class Employer {
	
	@Id  
	@GeneratedValue(strategy = GenerationType.IDENTITY)  
	@Column(name="product_id")
	private int Id;

	@Column(name="employer_companyname")
	private String companyname;
	
	@Column (name="employer_website")
	private String website;
	
	@Column (name="employer_phonenumber")
	private String phonenumber;
	
	@Column (name="employer_mail")
	private String mail;
	
	@Column (name="employer_password")
	private String password;
	
	@Column (name="employer_password2")
	private String password2;
}
