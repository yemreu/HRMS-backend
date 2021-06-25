package yunusemreuzun.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import yunusemreuzun.hrms.entities.concretes.Language;
import yunusemreuzun.hrms.entities.dtos.LanguageDto;

public interface LanguageDao extends JpaRepository<Language, Integer>{

	@Query("SELECT new yunusemreuzun.hrms.entities.dtos.LanguageDto(l.id,l.name,l.iso) FROM Language l")
	List<LanguageDto> getLanguageData();
}
