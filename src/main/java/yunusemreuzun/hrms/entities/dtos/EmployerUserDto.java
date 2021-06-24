package yunusemreuzun.hrms.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployerUserDto {

	private int id;
	private String companyName;
	private String email;
	private String phoneNumber;
	private String website;
	private boolean verifiedCompany;
	private boolean active;
}
