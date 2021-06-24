package yunusemreuzun.hrms.business.abstracts;

import java.util.List;

import yunusemreuzun.hrms.core.utilities.results.DataResult;
import yunusemreuzun.hrms.entities.concretes.CvLanguage;
import yunusemreuzun.hrms.entities.dtos.CvLanguageDto;

public interface CvLanguageService {

	DataResult<List<CvLanguageDto>> getSeekerCvLanguages(int cvId);
}
