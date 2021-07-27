package yunusemreuzun.hrms.entities.concretes;

import java.util.List;

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
@Table(name = "employer_users")
@PrimaryKeyJoinColumn(name = "user_id")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","jobs"})
public class EmployerUser extends User{

	@Column(name = "company_name")
	@NotBlank
	@NotNull
	private String companyName;
	
	@Column(name = "website")
	@NotBlank
	@NotNull
	private String website;
	
	@Column(name = "phone_number")
	@NotBlank
	@NotNull
	private String phoneNumber;
	
	@Column(name = "verified_company")
	private boolean verifiedCompany;
	
	@OneToMany(mappedBy = "employerUser")
	private List<Job> jobs;
	
	@OneToOne(mappedBy = "employerUser")
	@JsonIgnoreProperties("employerUser")
	private EmployerUserProfileUpdate employerUserProfileUpdate;
	
}
