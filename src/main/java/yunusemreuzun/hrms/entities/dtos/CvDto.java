package yunusemreuzun.hrms.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CvDto {

	private int id;
	private String imageUrl; //User.Image.imageUrl
	private String coverLetterTitle; //CoverLetter.title
	private String coverLetterBody; //CoverLetter.body
	private String skills;
}
