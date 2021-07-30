package yunusemreuzun.hrms.entities.dtos;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaginatedJobDto {

	List<JobDto> paginatedJob;
	long jobCount;
}
