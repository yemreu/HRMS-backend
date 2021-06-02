package yunusemreuzun.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import yunusemreuzun.hrms.business.abstracts.JobTitleService;
import yunusemreuzun.hrms.dataAccess.abstracts.JobTitleDao;
import yunusemreuzun.hrms.entities.concretes.JobTitle;

@Service
public class JobTitleManager implements JobTitleService{
	
	private JobTitleDao jobTitleDao;

	@Autowired
	public JobTitleManager(JobTitleDao jobTitleDao) {
		this.jobTitleDao = jobTitleDao;
	}

	@Override
	public List<JobTitle> getAll() {
		return jobTitleDao.findAll();
	}

}
