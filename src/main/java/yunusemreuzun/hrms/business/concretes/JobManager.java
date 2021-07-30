package yunusemreuzun.hrms.business.concretes;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import yunusemreuzun.hrms.business.abstracts.JobService;
import yunusemreuzun.hrms.core.utilities.results.DataResult;
import yunusemreuzun.hrms.core.utilities.results.ErrorDataResult;
import yunusemreuzun.hrms.core.utilities.results.Result;
import yunusemreuzun.hrms.core.utilities.results.SuccessDataResult;
import yunusemreuzun.hrms.core.utilities.results.SuccessResult;
import yunusemreuzun.hrms.dataAccess.abstracts.FavoriteJobDao;
import yunusemreuzun.hrms.dataAccess.abstracts.JobDao;
import yunusemreuzun.hrms.entities.concretes.FavoriteJob;
import yunusemreuzun.hrms.entities.concretes.Job;
import yunusemreuzun.hrms.entities.dtos.JobDto;
import yunusemreuzun.hrms.entities.dtos.JobFilterDto;
import yunusemreuzun.hrms.entities.dtos.PaginatedJobDto;

@Service
public class JobManager implements JobService {

	private JobDao jobDao;
	private FavoriteJobDao favoriteJobDao;

	@Autowired
	public JobManager(JobDao jobDao,FavoriteJobDao favoriteJobDao) {
		this.jobDao = jobDao;
		this.favoriteJobDao = favoriteJobDao;
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
				"Tüm aktif ilanları son başvuru tarihine göre sıralandı.");
	}
	
	@Override
	public Result activateJob(int id) {
		Job job = jobDao.getById(id);
		job.setActive(true);
		jobDao.save(job);
		return new SuccessResult("İş ilanı aktifleştirildi.");
	}

	@Override
	public Result deactivateJob(int id) {
		Job job = jobDao.getById(id);
		job.setActive(false);
		jobDao.save(job);
		return new SuccessResult("İş ilanı kaldırıldı.");
	}
	
	@Override
	public DataResult<List<JobDto>> getActiveJobData() {
		return new SuccessDataResult<List<JobDto>>(jobDao.getActiveJobData(), "Tüm aktif iş ilanları listelendi.");
	}
	
	@Override
	public DataResult<List<JobDto>> getInActiveJobData() {
		return new SuccessDataResult<List<JobDto>>(jobDao.getInactiveJobData(), "Tüm inaktif iş ilanları listelendi.");
	}
	
	@Override
	public DataResult<List<JobDto>> getEmployerActiveJobData(int userId) {
		return new SuccessDataResult<List<JobDto>>(jobDao.getEmployerActiveJobData(userId), "İşverene ait tüm aktif iş ilanları listelendi.");
	}

	@Override 
	public DataResult<List<JobDto>> getActiveJobByLastApplicationDateData(LocalDate date){
		return new SuccessDataResult<List<JobDto>>(jobDao.getActiveJobByLastApplicationDateData(date), "Tüm aktif ilanları son başvuru tarihine göre sıralandı.");
	}

	@Override
	public DataResult<JobDto> getJobData(int jobId) {
		if(!jobDao.existsById(jobId)) return new ErrorDataResult<JobDto>("İş ilanı mevcut değil.");
		return new SuccessDataResult<JobDto>(jobDao.getJobData(jobId), "İş ilanı getirildi.");
	}

	@Override
	public Result addToFavorite(FavoriteJob favoriteJob) {
		favoriteJobDao.save(favoriteJob);
		return new SuccessResult("Favorilere eklendi.");
	}

	@Override
	public DataResult<PaginatedJobDto> getFilteredJobWithPaginationData(JobFilterDto jobFilter, int activePage, int pageSize) {
		Page<JobDto> jobDto = jobDao.getFilteredJobWithPaginationData(jobFilter,PageRequest.of(activePage - 1, pageSize));
		PaginatedJobDto paginatedJobDto = new PaginatedJobDto(jobDto.getContent(), jobDto.getTotalElements());
		return new SuccessDataResult<PaginatedJobDto>(paginatedJobDto, "Filtrelenmiş iş ilanları getirildi.");
	}
}
