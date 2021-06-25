package yunusemreuzun.hrms.business.abstracts;

import java.util.List;

import yunusemreuzun.hrms.core.utilities.results.DataResult;
import yunusemreuzun.hrms.entities.dtos.EducationDto;

public interface EducationService {

	DataResult<List<EducationDto>> getSeekerCvEducations(int cvId);
}
