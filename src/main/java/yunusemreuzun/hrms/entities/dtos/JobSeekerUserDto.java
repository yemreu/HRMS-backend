package yunusemreuzun.hrms.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JobSeekerUserDto {

	private int id;
	private String firstName;
	private String lastName;
	private String email;
	private String nationalIdentity;
	private String yearOfBirth;
	private boolean active;
}
