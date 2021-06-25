package yunusemreuzun.hrms.business.abstracts;

import java.util.List;

import yunusemreuzun.hrms.core.utilities.results.DataResult;
import yunusemreuzun.hrms.core.utilities.results.Result;
import yunusemreuzun.hrms.entities.concretes.CoverLetter;
import yunusemreuzun.hrms.entities.dtos.CoverLetterDto;

public interface CoverLetterService {

	Result add(CoverLetter coverLetter);
	
	DataResult<List<CoverLetterDto>> getCoverLetterData(int userId);

}
