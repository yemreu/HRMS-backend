package yunusemreuzun.hrms.business.abstracts;

import java.util.List;

import yunusemreuzun.hrms.core.utilities.results.DataResult;
import yunusemreuzun.hrms.core.utilities.results.Result;
import yunusemreuzun.hrms.entities.concretes.JobTitle;

public interface JobTitleService {

	DataResult<List<JobTitle>> getAll();
	
	Result add(JobTitle jobTitle);
}
