package yunusemreuzun.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import yunusemreuzun.hrms.entities.concretes.Education;
import yunusemreuzun.hrms.entities.dtos.EducationDto;

public interface EducationDao extends JpaRepository<Education, Integer>{

	@Query("SELECT new yunusemreuzun.hrms.entities.dtos.EducationDto(e.id,e.institutionName,e.department,e.startingDate,e.completionDate) FROM Education e INNER JOIN e.cv c WHERE c.id = :cvId ORDER BY e.completionDate DESC")
	List<EducationDto> getByCv_Id(int cvId);
}
