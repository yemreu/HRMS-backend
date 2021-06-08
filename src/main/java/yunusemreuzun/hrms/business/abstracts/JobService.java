package yunusemreuzun.hrms.business.abstracts;

import yunusemreuzun.hrms.core.utilities.results.Result;
import yunusemreuzun.hrms.entities.concretes.Job;

public interface JobService {

	Result add(Job job);
}
