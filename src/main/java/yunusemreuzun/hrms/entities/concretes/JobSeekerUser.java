package yunusemreuzun.hrms.entities.concretes;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper=false)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "job_seeker_users")
@PrimaryKeyJoinColumn(name = "user_id")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","cv"})
public class JobSeekerUser extends User{
	
	@Column(name = "first_name")
	@NotBlank
	@NotNull
	private String firstName;
	
	@Column(name = "last_name")
	@NotBlank
	@NotNull
	private String lastName;
	
	@Column(name = "national_identity")
	@NotBlank
	@NotNull
	private String nationalIdentity;
	
	@Column(name = "year_of_birth")
	@NotBlank
	@NotNull
	private String yearOfBirth;
	
	@OneToOne(mappedBy = "jobSeekerUser", cascade = CascadeType.ALL)
	private Cv cv;
	
	@OneToMany(mappedBy = "jobSeekerUser")
	@JsonIgnoreProperties("jobSeekerUser")
	private List<CoverLetter> coverLetters;
}
