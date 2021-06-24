package yunusemreuzun.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import yunusemreuzun.hrms.entities.concretes.JobTitle;
import yunusemreuzun.hrms.entities.dtos.JobTitleDto;

public interface JobTitleDao extends JpaRepository<JobTitle, Integer>{

	boolean existsByTitle(String title);
	
	@Query("SELECT new yunusemreuzun.hrms.entities.dtos.JobTitleDto(jt.id,jt.title) FROM  JobTitle jt")
	List<JobTitleDto> getJobtitleData();
}
