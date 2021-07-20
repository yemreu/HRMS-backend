package yunusemreuzun.hrms.entities.dtos;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExperienceDto {

	private int id;
	private String companyName;
	private String title;
	private LocalDate startDate;
	private LocalDate endDate;
}
