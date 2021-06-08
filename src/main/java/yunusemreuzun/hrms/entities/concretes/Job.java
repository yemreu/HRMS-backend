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
	private String description;
	
	@Column(name = "salary_range")
	private String salaryRange;
	
	@Column(name = "vacancy")
	private int vacancy;
	
	@Column(name = "posting_date")
	private LocalDate postingDate;
	
	@Column(name = "last_application_date")
	private LocalDate lastApplicationDate;
	
	@Column(name = "active")
	private boolean active;
	
	@ManyToOne
	@JoinColumn(name = "employer_user_id")
	private EmployerUser employer;
	
	@ManyToOne
	@JoinColumn(name = "job_title_id")
	private JobTitle title;
	
	@ManyToOne
	@JoinColumn(name = "city_code")
	private City city;
}
