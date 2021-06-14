package yunusemreuzun.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
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
@Table(name = "cover_letters")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","cv"})
public class CoverLetter {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "title")
	@NotBlank
	@NotNull
	private String title;
	
	@Column(name = "body")
	@NotBlank
	@NotNull
	private String body;
	
	@ManyToOne
	@JoinColumn(name = "job_seeker_user_id")
	@JsonIgnoreProperties("coverLetters")
	private JobSeekerUser jobSeekerUser;
	
	@OneToOne(mappedBy = "coverLetter")
	private Cv cv;
}
