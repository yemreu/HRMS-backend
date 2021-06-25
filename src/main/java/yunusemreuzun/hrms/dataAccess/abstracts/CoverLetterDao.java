package yunusemreuzun.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import yunusemreuzun.hrms.entities.concretes.CoverLetter;
import yunusemreuzun.hrms.entities.dtos.CoverLetterDto;

public interface CoverLetterDao extends JpaRepository<CoverLetter, Integer>{

	@Query("SELECT new yunusemreuzun.hrms.entities.dtos.CoverLetterDto(cl.id,cl.title,cl.body) FROM CoverLetter cl INNER JOIN cl.jobSeekerUser js WHERE js.id = :userId")
	List<CoverLetterDto> getCoverLetterData(int userId);
	
}
