package yunusemreuzun.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import yunusemreuzun.hrms.business.abstracts.SocialLinkService;
import yunusemreuzun.hrms.core.utilities.results.DataResult;
import yunusemreuzun.hrms.core.utilities.results.SuccessDataResult;
import yunusemreuzun.hrms.dataAccess.abstracts.SocialLinkDao;
import yunusemreuzun.hrms.entities.dtos.SocialLinkDto;

@Service
public class SocialLinkManager implements SocialLinkService{

private SocialLinkDao socialLinkDao;
	
	@Autowired
	public SocialLinkManager(SocialLinkDao socialLinkDao) {
		this.socialLinkDao = socialLinkDao;
	}

	@Override
	public DataResult<List<SocialLinkDto>> getSeekerCvSocialLinks(int cvId) {
		return new SuccessDataResult<List<SocialLinkDto>>(socialLinkDao.getByCv_Id(cvId));
	}
}
