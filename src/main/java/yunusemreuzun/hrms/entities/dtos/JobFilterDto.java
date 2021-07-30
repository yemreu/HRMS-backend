package yunusemreuzun.hrms.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JobFilterDto {

	private Integer cityCode;
	private Boolean fullTime;
	
}
