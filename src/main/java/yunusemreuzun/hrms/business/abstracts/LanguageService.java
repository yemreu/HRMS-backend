package yunusemreuzun.hrms.business.abstracts;

import java.util.List;

import yunusemreuzun.hrms.core.utilities.results.DataResult;
import yunusemreuzun.hrms.core.utilities.results.Result;
import yunusemreuzun.hrms.entities.concretes.Language;
import yunusemreuzun.hrms.entities.dtos.LanguageDto;

public interface LanguageService {

	Result add(Language language);
	
    DataResult<List<LanguageDto>> getAll();
}
