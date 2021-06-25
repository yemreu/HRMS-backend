package yunusemreuzun.hrms.business.abstracts;

import java.time.LocalDate;
import java.util.List;

import yunusemreuzun.hrms.core.utilities.results.DataResult;
import yunusemreuzun.hrms.core.utilities.results.Result;
import yunusemreuzun.hrms.entities.concretes.Job;
import yunusemreuzun.hrms.entities.dtos.JobDto;

public interface JobService {

	Result add(Job job);
	
	DataResult<List<Job>> getActiveJobs();
	
	DataResult<List<Job>> getEmployerActiveJobs(int userId);
	
	DataResult<List<Job>> getActiveJobsWithLastApplicationDate(LocalDate date);
	
	Result deactivateJob(int id);
	
	DataResult<List<JobDto>> getActiveJobData();
	
	DataResult<List<JobDto>> getEmployerActiveJobData(int userId);
	
	DataResult<List<JobDto>> getActiveJobByLastApplicationDateData(LocalDate date);
	
}
