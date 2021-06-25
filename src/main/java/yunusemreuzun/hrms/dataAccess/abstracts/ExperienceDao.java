package yunusemreuzun.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import yunusemreuzun.hrms.entities.concretes.Experience;
import yunusemreuzun.hrms.entities.dtos.ExperienceDto;

public interface ExperienceDao extends JpaRepository<Experience, Integer>{

	@Query("SELECT new yunusemreuzun.hrms.entities.dtos.ExperienceDto(e.id,e.companyName,e.title,e.startDate,e.endDate) FROM Experience e INNER JOIN e.cv c WHERE c.id = :cvId ORDER BY e.endDate DESC")
	List<ExperienceDto> getByCv_Id(int cvId);
}
