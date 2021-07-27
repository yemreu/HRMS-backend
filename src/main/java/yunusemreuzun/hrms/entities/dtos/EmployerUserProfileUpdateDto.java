package yunusemreuzun.hrms.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployerUserProfileUpdateDto {

	private int id;
	private int userId;
	private String companyName;
	private String website;
	private String phoneNumber;
}
