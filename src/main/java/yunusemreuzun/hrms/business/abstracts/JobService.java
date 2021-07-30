package yunusemreuzun.hrms.business.abstracts;

import java.time.LocalDate;
import java.util.List;

import yunusemreuzun.hrms.core.utilities.results.DataResult;
import yunusemreuzun.hrms.core.utilities.results.Result;
import yunusemreuzun.hrms.entities.concretes.FavoriteJob;
import yunusemreuzun.hrms.entities.concretes.Job;
import yunusemreuzun.hrms.entities.dtos.JobDto;
import yunusemreuzun.hrms.entities.dtos.JobFilterDto;
import yunusemreuzun.hrms.entities.dtos.PaginatedJobDto;

public interface JobService {

	Result add(Job job);
	
	DataResult<List<Job>> getActiveJobs();
	
	DataResult<List<Job>> getEmployerActiveJobs(int userId);
	
	DataResult<List<Job>> getActiveJobsWithLastApplicationDate(LocalDate date);
	
	Result activateJob(int id);
	
	Result deactivateJob(int id);
	
	DataResult<List<JobDto>> getActiveJobData();
	
	DataResult<List<JobDto>> getInActiveJobData();
	
	DataResult<List<JobDto>> getEmployerActiveJobData(int userId);
	
	DataResult<List<JobDto>> getActiveJobByLastApplicationDateData(LocalDate date);
	
	DataResult<JobDto> getJobData(int jobId);
	
	Result addToFavorite(FavoriteJob favoriteJob);
	
	DataResult<PaginatedJobDto> getFilteredJobWithPaginationData(JobFilterDto jobFilter,int activePage, int pageSize);
	
}
