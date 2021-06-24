package yunusemreuzun.hrms.entities.dtos;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JobDto {

	private int id;
	private String companyName; //EmployerUser.companyName
	private String jobTitle; //JobTitle.title
	private String description;
	private String minSalary;
	private String maxSalary;
	private int vacancy;
	private LocalDate postingDate;
	private LocalDate lastApplicationDate;
}
