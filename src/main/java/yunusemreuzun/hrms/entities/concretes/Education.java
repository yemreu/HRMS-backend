package yunusemreuzun.hrms.entities.concretes;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "educations")
public class Education {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "institution_name")
	@NotBlank
	@NotNull
	private String institutionName;
	
	@Column(name = "department")
	private String department;
	
	@Column(name = "starting_date")
	@NotNull
	private LocalDate startingDate;
	
	@Column(name = "completion_date")
	private LocalDate completionDate;
	
	@ManyToOne
	@JoinColumn(name = "cv_id")
	@JsonIgnoreProperties("educations")
	private Cv cv;
}
