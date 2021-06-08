package yunusemreuzun.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import yunusemreuzun.hrms.dataAccess.abstracts.projections.IdOnly;
import yunusemreuzun.hrms.entities.concretes.JobSeekerUser;

public interface JobSeekerUserDao extends JpaRepository<JobSeekerUser, Integer>{

	boolean existsByEmail(String email);
	boolean existsByNationalIdentity(String nationalIdentity);
	List<IdOnly> getByEmail(String email);
	
}
