package yunusemreuzun.hrms.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "cities")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","jobs"})
public class City {

	@Id
	@Column(name = "code")
	@NotBlank
	@NotNull
	private int code;
	
	@Column(name = "name")
	@NotBlank
	@NotNull
	private String name;
	
	@OneToMany(mappedBy = "city")
	private List<Job> jobs;
}
