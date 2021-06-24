package yunusemreuzun.hrms.business.abstracts;

import java.util.List;

import yunusemreuzun.hrms.core.utilities.results.DataResult;
import yunusemreuzun.hrms.core.utilities.results.Result;
import yunusemreuzun.hrms.entities.concretes.EmployerUser;
import yunusemreuzun.hrms.entities.dtos.EmployerUserDto;

public interface EmployerUserService {

	Result register(EmployerUser employerUser);
	Result verify(int companyId);
	DataResult<List<EmployerUser>> getAll();
	DataResult<List<EmployerUserDto>> getEmployerUserData();
}
