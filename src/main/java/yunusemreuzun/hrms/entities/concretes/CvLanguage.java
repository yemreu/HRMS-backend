package yunusemreuzun.hrms.entities.concretes;

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
@Table(name = "cvs_languages")
public class CvLanguage {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "level")
	@NotBlank
	@NotNull
	private int level;
	
	@ManyToOne
	@JoinColumn(name = "cv_id")
	@JsonIgnoreProperties("languages")
	private Cv cv;
	
	@ManyToOne
	@JoinColumn(name = "language_id")
	@JsonIgnoreProperties("cvs")
	private Language language;
}
