package yunusemreuzun.hrms.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "cities")
public class City {

	@Id
	@Column(name = "code")
	private int code;
	
	@Column(name = "name")
	private String name;
	
	@OneToMany(mappedBy = "city")
	private List<Job> jobs;
}
