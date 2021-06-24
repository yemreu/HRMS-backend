package yunusemreuzun.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import yunusemreuzun.hrms.dataAccess.abstracts.projections.IdOnly;
import yunusemreuzun.hrms.entities.concretes.JobSeekerUser;
import yunusemreuzun.hrms.entities.dtos.JobSeekerUserDto;

public interface JobSeekerUserDao extends JpaRepository<JobSeekerUser, Integer>{

	boolean existsByEmail(String email);
	boolean existsByNationalIdentity(String nationalIdentity);
	List<IdOnly> getByEmail(String email);
	
	@Query("SELECT new yunusemreuzun.hrms.entities.dtos.JobSeekerUserDto(js.id,js.firstName,js.lastName,js.email,js.nationalIdentity,js.yearOfBirth,js.active) FROM  JobSeekerUser js")
	List<JobSeekerUserDto> getJobSeekerUserData();
}
