package yunusemreuzun.hrms.business.abstracts;

import yunusemreuzun.hrms.core.utilities.results.Result;
import yunusemreuzun.hrms.entities.concretes.JobSeekerUser;

public interface JobSeekerUserService {

	Result register(JobSeekerUser jobSeekerUser);
}
