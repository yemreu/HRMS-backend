package yunusemreuzun.hrms.entities.concretes;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "jobs")
public class Job {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "description")
	@NotBlank
	@NotNull
	private String description;
	
	@Column(name = "min_salary")
	private String minSalary;
	
	@Column(name = "max_salary")
	private String maxSalary;
	
	@Column(name = "vacancy")
	@NotNull
	private int vacancy;
	
	@Column(name = "posting_date")
	private LocalDate postingDate = LocalDate.now();
	
	@Column(name = "last_application_date")
	@NotNull
	private LocalDate lastApplicationDate;
	
	@Column(name = "active")
	private boolean active = false;
	
	@Column(name = "remote")
	private boolean remote = false;
	
	@Column(name = "full_time")
	private boolean fullTime = false;
	
	@ManyToOne
	@JoinColumn(name = "employer_user_id")
	private EmployerUser employerUser;
	
	@ManyToOne
	@JoinColumn(name = "job_title_id")
	private JobTitle jobTitle;
	
	@ManyToOne
	@JoinColumn(name = "city_code")
	private City city;
	
	@OneToMany(mappedBy = "job")
	private List<FavoriteJob> favoriteJob;
}
