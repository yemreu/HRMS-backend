package yunusemreuzun.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import yunusemreuzun.hrms.entities.concretes.CvLanguage;
import yunusemreuzun.hrms.entities.dtos.CvLanguageDto;

public interface CvLanguageDao extends JpaRepository<CvLanguage, Integer>{
	
	@Query("SELECT new yunusemreuzun.hrms.entities.dtos.CvLanguageDto(l.name,cl.level) FROM CvLanguage cl INNER JOIN cl.language l INNER JOIN cl.cv c WHERE c.id = :cvId")
	List<CvLanguageDto> getByCv_Id(int cvId);

}
