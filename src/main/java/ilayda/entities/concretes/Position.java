package ilayda.entities.concretes;

import javax.persistence.*;

import lombok.Data;

@Data
@Table (name="positions") 
@Entity
public class Position {

	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="position_id")
	private int id;
	
	@Column (name = "position_name")
	private String positionname;
	
}
