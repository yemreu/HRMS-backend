package yunusemreuzun.hrms.business.abstracts;

import yunusemreuzun.hrms.core.utilities.results.DataResult;
import yunusemreuzun.hrms.core.utilities.results.Result;
import yunusemreuzun.hrms.entities.concretes.Cv;
import yunusemreuzun.hrms.entities.dtos.CvDto;

public interface CvService {

	Result save(Cv cv);
	
	DataResult<Cv> getSeekerCv(int id);
	
	Result selectCoverLetter(int userId, int coverId);
	
	DataResult<CvDto> getSeekerCvData(int userId);
}
