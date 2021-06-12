package yunusemreuzun.hrms.entities.concretes;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "cvs")
public class Cv {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "skills")
	private String skills;
	
	@OneToOne
	@JoinColumn(name = "job_seeker_user_id")
	private JobSeekerUser jobSeekerUser;
	
	@OneToMany(mappedBy = "cv", cascade = CascadeType.ALL)
	@OrderBy(value = "completion_date desc")
	@JsonIgnoreProperties("cv")
	private List<Education> educations;
	
	@OneToMany(mappedBy = "cv", cascade = CascadeType.ALL)
	@OrderBy(value = "end_date desc")
	@JsonIgnoreProperties("cv")
	private List<Experience> experiences;
	
	@OneToMany(mappedBy = "cv", cascade = CascadeType.ALL)
	@JsonIgnoreProperties("cv")
	private List<CvLanguage> languages;
	
	@OneToMany(mappedBy = "cv", cascade = CascadeType.ALL)
	@JsonIgnoreProperties("cv")
	private List<SocialLink> socialLinks;
	
	@OneToOne
	@JoinColumn(name = "cover_letter_id")
	private CoverLetter coverLetter;
}
