package yunusemreuzun.hrms.business.abstracts;

import java.util.List;

import yunusemreuzun.hrms.core.utilities.results.DataResult;
import yunusemreuzun.hrms.core.utilities.results.Result;
import yunusemreuzun.hrms.entities.concretes.SocialPlatform;
import yunusemreuzun.hrms.entities.dtos.SocialPlatformDto;

public interface SocialPlatformService {

	DataResult<List<SocialPlatformDto>> getAll();
	
	Result add(SocialPlatform socialPlatform);
}
