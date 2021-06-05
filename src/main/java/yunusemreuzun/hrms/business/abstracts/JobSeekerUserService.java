package yunusemreuzun.hrms.business.abstracts;

import java.util.List;

import yunusemreuzun.hrms.core.utilities.results.DataResult;
import yunusemreuzun.hrms.core.utilities.results.Result;
import yunusemreuzun.hrms.entities.concretes.JobSeekerUser;

public interface JobSeekerUserService {

	Result register(JobSeekerUser jobSeekerUser);
	DataResult<List<JobSeekerUser>> getAll();
}
