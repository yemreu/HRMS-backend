package yunusemreuzun.hrms.dataAccess.abstracts;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import yunusemreuzun.hrms.entities.concretes.Job;
import yunusemreuzun.hrms.entities.dtos.JobDto;
import yunusemreuzun.hrms.entities.dtos.JobFilterDto;

public interface JobDao extends JpaRepository<Job, Integer>{

	List<Job> getByActiveTrue();
	
	List<Job> getByEmployerUser_IdAndActiveTrue(int userId);
	
	List<Job> getByLastApplicationDateAndActiveTrue(LocalDate date);
	
	Job getById(int id);
	
	@Query("SELECT new yunusemreuzun.hrms.entities.dtos.JobDto(j.id,e.companyName,jt.title,c.name,j.description,j.minSalary,j.maxSalary,j.vacancy,j.postingDate,j.lastApplicationDate,j.remote,j.fullTime) FROM Job j INNER JOIN j.employerUser e INNER JOIN j.jobTitle jt INNER JOIN j.city c WHERE j.active = true")
	List<JobDto> getActiveJobData();
	
	@Query("SELECT new yunusemreuzun.hrms.entities.dtos.JobDto(j.id,e.companyName,jt.title,c.name,j.description,j.minSalary,j.maxSalary,j.vacancy,j.postingDate,j.lastApplicationDate,j.remote,j.fullTime) FROM Job j INNER JOIN j.employerUser e INNER JOIN j.jobTitle jt INNER JOIN j.city c WHERE j.active = false")
	List<JobDto> getInactiveJobData();
	
	@Query("SELECT new yunusemreuzun.hrms.entities.dtos.JobDto(j.id,e.companyName,jt.title,c.name,j.description,j.minSalary,j.maxSalary,j.vacancy,j.postingDate,j.lastApplicationDate,j.remote,j.fullTime) FROM Job j INNER JOIN j.employerUser e INNER JOIN j.jobTitle jt INNER JOIN j.city c WHERE j.active = true AND e.id = :userId")
	List<JobDto> getEmployerActiveJobData(int userId);
	
	@Query("SELECT new yunusemreuzun.hrms.entities.dtos.JobDto(j.id,e.companyName,jt.title,c.name,j.description,j.minSalary,j.maxSalary,j.vacancy,j.postingDate,j.lastApplicationDate,j.remote,j.fullTime) FROM Job j INNER JOIN j.employerUser e INNER JOIN j.jobTitle jt INNER JOIN j.city c WHERE j.active = true AND j.lastApplicationDate = :date")
	List<JobDto> getActiveJobByLastApplicationDateData(LocalDate date);
	
	@Query("SELECT new yunusemreuzun.hrms.entities.dtos.JobDto(j.id,e.companyName,jt.title,c.name,j.description,j.minSalary,j.maxSalary,j.vacancy,j.postingDate,j.lastApplicationDate,j.remote,j.fullTime) FROM Job j INNER JOIN j.employerUser e INNER JOIN j.jobTitle jt INNER JOIN j.city c WHERE j.id = :jobId")
	JobDto getJobData(int jobId);
	
	@Query("SELECT new yunusemreuzun.hrms.entities.dtos.JobDto(j.id,e.companyName,jt.title,c.name,j.description,j.minSalary,j.maxSalary,j.vacancy,j.postingDate,j.lastApplicationDate,j.remote,j.fullTime) FROM Job j INNER JOIN j.employerUser e INNER JOIN j.jobTitle jt INNER JOIN j.city c WHERE j.active = true AND (:#{#filter.cityCode} IS NULL OR c.code = :#{#filter.cityCode}) AND (:#{#filter.fullTime} IS NULL OR j.fullTime = :#{#filter.fullTime})")
	Page<JobDto> getFilteredJobWithPaginationData(@Param("filter") JobFilterDto jobFilterDto, Pageable pageable);
}
