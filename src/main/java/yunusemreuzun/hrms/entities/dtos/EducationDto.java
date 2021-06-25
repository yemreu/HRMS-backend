package yunusemreuzun.hrms.entities.dtos;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EducationDto {

	private int id;
	private String institutionName;
	private String department;
	private LocalDate startingDate;
	private LocalDate completionDate;
}
