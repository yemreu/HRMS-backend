package yunusemreuzun.hrms.business.abstracts;

import java.util.List;

import yunusemreuzun.hrms.core.utilities.results.DataResult;
import yunusemreuzun.hrms.core.utilities.results.Result;
import yunusemreuzun.hrms.entities.concretes.EmployerUser;
import yunusemreuzun.hrms.entities.concretes.EmployerUserProfileUpdate;
import yunusemreuzun.hrms.entities.dtos.EmployerUserDto;
import yunusemreuzun.hrms.entities.dtos.EmployerUserProfileUpdateDto;

public interface EmployerUserService {

	Result register(EmployerUser employerUser);
	Result verify(int companyId);
	DataResult<List<EmployerUser>> getAll();
	DataResult<List<EmployerUserDto>> getAllEmployerUserData();
	DataResult<EmployerUserDto> getEmployerUserData(int userId);
	Result update(EmployerUserProfileUpdate profileUpdate);
	DataResult<EmployerUserProfileUpdateDto> getEmployerProfileUpdateData(int id);
	DataResult<List<EmployerUserProfileUpdateDto>> getEmployerUserProfileUpdatesData();
	Result approveProfileUpdate(int profileUpdateId);
	Result existsEmployerProfileUpdate(int userId);
	
}
