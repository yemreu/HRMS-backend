package yunusemreuzun.hrms.business.abstracts;

import java.time.LocalDate;
import java.util.List;

import yunusemreuzun.hrms.core.utilities.results.DataResult;
import yunusemreuzun.hrms.core.utilities.results.Result;
import yunusemreuzun.hrms.entities.concretes.Job;

public interface JobService {

	Result add(Job job);
	
	DataResult<List<Job>> getActiveJobs();
	
	DataResult<List<Job>> getEmployerActiveJobs(int userId);
	
	DataResult<List<Job>> getActiveJobsWithLastApplicationDate(LocalDate date);
	
	Result deactivateJob(int id);
}
