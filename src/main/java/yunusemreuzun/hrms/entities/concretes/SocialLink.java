package yunusemreuzun.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "social_links")
public class SocialLink {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "profile_name")
	private String profileName;
	
	@ManyToOne
	@JoinColumn(name = "social_platform_id")
	@JsonIgnoreProperties("socialLinks")
	private SocialPlatform socialPlatform;
	
	@ManyToOne
	@JoinColumn(name = "cv_id")
	@JsonIgnoreProperties("socialLinks")
	private Cv cv;
}
