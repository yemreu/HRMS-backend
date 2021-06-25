package yunusemreuzun.hrms.business.abstracts;

import java.util.List;

import yunusemreuzun.hrms.core.utilities.results.DataResult;
import yunusemreuzun.hrms.entities.dtos.SocialLinkDto;

public interface SocialLinkService {

	DataResult<List<SocialLinkDto>> getSeekerCvSocialLinks(int cvId);
}
