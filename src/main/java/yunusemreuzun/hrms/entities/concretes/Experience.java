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
@Table(name = "experiences")
public class Experience {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "company_name")
	@NotBlank
	@NotNull
	private String companyName;
	
	@Column(name = "title")
	@NotBlank
	@NotNull
	private String title;
	
	@Column(name = "start_date")
	@NotNull
	private LocalDate startDate;
	
	@Column(name = "end_date")
	private LocalDate endDate;
	
	@ManyToOne
	@JoinColumn(name = "cv_id")
	@JsonIgnoreProperties("experiences")
	private Cv cv;
}
