package yunusemreuzun.hrms.business.abstracts;

import yunusemreuzun.hrms.core.utilities.results.Result;

public interface UserVerificationService {

	Result verify(String token);
}
