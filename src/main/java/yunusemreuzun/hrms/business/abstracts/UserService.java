package yunusemreuzun.hrms.business.abstracts;

import yunusemreuzun.hrms.core.utilities.results.Result;

public interface UserService {

	Result updateEmail(int userId, String email);
	Result updatePassword(int userId, String password);
}
