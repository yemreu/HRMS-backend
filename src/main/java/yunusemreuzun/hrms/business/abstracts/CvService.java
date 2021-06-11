package yunusemreuzun.hrms.business.abstracts;

import yunusemreuzun.hrms.core.utilities.results.DataResult;
import yunusemreuzun.hrms.core.utilities.results.Result;
import yunusemreuzun.hrms.entities.concretes.Cv;

public interface CvService {

	Result save(Cv cv);
	
	DataResult<Cv> getSeekerCv(int id);
}
