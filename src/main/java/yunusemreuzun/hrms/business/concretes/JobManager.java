package yunusemreuzun.hrms.business.concretes;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import yunusemreuzun.hrms.business.abstracts.JobService;
import yunusemreuzun.hrms.core.utilities.results.DataResult;
import yunusemreuzun.hrms.core.utilities.results.Result;
import yunusemreuzun.hrms.core.utilities.results.SuccessDataResult;
import yunusemreuzun.hrms.core.utilities.results.SuccessResult;
import yunusemreuzun.hrms.dataAccess.abstracts.JobDao;
import yunusemreuzun.hrms.entities.concretes.Job;
import yunusemreuzun.hrms.entities.dtos.JobDto;

@Service
public class JobManager implements JobService {

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

	@Override
	public DataResult<List<Job>> getActiveJobs() {
		return new SuccessDataResult<List<Job>>(jobDao.getByActiveTrue(), "Tüm aktif iş ilanları listelendi.");
	}

	@Override
	public DataResult<List<Job>> getEmployerActiveJobs(int userId) {
		return new SuccessDataResult<List<Job>>(jobDao.getByEmployerUser_IdAndActiveTrue(userId),
				"İşverene ait tüm aktif iş ilanları listelendi.");
	}

	@Override
	public DataResult<List<Job>> getActiveJobsWithLastApplicationDate(LocalDate date) {
		return new SuccessDataResult<List<Job>>(jobDao.getByLastApplicationDateAndActiveTrue(date),
				"Tüm aktif ilanları tarihe göre sıralandı.");
	}

	@Override
	public Result deactivateJob(int id) {
		Job job = jobDao.getById(id);
		job.setActive(false);
		jobDao.save(job);
		return new SuccessResult("İş ilanı kaldırıldı.");
	}
	
	@Override
	public DataResult<List<JobDto>> getJobData() {
		return new SuccessDataResult<List<JobDto>>(jobDao.getActiveJobData(), "İş arayanlar listelendi.");
	}

}
