package yunusemreuzun.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import yunusemreuzun.hrms.business.abstracts.JobService;
import yunusemreuzun.hrms.core.utilities.results.Result;
import yunusemreuzun.hrms.core.utilities.results.SuccessResult;
import yunusemreuzun.hrms.dataAccess.abstracts.JobDao;
import yunusemreuzun.hrms.entities.concretes.Job;

@Service
public class JobManager implements JobService{
	
	private JobDao jobDao;

	@Autowired
	public JobManager(JobDao jobDao) {
		this.jobDao = jobDao;
	}

	@Override
	public Result add(Job job) {
		jobDao.save(job);
		return new SuccessResult("Yeni iş ilanı eklendi");
	}

}
