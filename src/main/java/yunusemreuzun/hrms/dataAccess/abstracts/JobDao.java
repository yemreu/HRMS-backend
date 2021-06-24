package yunusemreuzun.hrms.dataAccess.abstracts;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import yunusemreuzun.hrms.entities.concretes.Job;
import yunusemreuzun.hrms.entities.dtos.JobDto;

public interface JobDao extends JpaRepository<Job, Integer>{

	List<Job> getByActiveTrue();
	
	List<Job> getByEmployerUser_IdAndActiveTrue(int userId);
	
	List<Job> getByLastApplicationDateAndActiveTrue(LocalDate date);
	
	Job getById(int id);
	
	@Query("SELECT new yunusemreuzun.hrms.entities.dtos.JobDto(j.id,e.companyName,jt.title,j.description,j.minSalary,j.maxSalary,j.vacancy,j.postingDate,j.lastApplicationDate) FROM Job j INNER JOIN j.employerUser e INNER JOIN j.jobTitle jt WHERE j.active = true")
	List<JobDto> getActiveJobData();
}
