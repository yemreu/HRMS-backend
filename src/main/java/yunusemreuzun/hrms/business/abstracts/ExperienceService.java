package yunusemreuzun.hrms.business.abstracts;

import java.util.List;

import yunusemreuzun.hrms.core.utilities.results.DataResult;
import yunusemreuzun.hrms.entities.dtos.ExperienceDto;

public interface ExperienceService {

	DataResult<List<ExperienceDto>> getSeekerCvExperiences(int cvId);
}
