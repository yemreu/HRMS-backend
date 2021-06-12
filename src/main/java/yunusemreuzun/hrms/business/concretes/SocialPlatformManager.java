package yunusemreuzun.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import yunusemreuzun.hrms.business.abstracts.SocialPlatformService;
import yunusemreuzun.hrms.core.utilities.results.DataResult;
import yunusemreuzun.hrms.core.utilities.results.Result;
import yunusemreuzun.hrms.core.utilities.results.SuccessDataResult;
import yunusemreuzun.hrms.core.utilities.results.SuccessResult;
import yunusemreuzun.hrms.dataAccess.abstracts.SocialPlatformDao;
import yunusemreuzun.hrms.entities.concretes.SocialPlatform;

@Service
public class SocialPlatformManager implements SocialPlatformService{

	private SocialPlatformDao socialPlatformDao;
	
	@Autowired
	public SocialPlatformManager(SocialPlatformDao socialPlatformDao) {
		this.socialPlatformDao = socialPlatformDao;
	}

	@Override
	public DataResult<List<SocialPlatform>> getAll() {
		return new SuccessDataResult<List<SocialPlatform>>(socialPlatformDao.findAll(), "Tüm sosyal platformlar listelendi.");
	}

	@Override
	public Result add(SocialPlatform socialPlatform) {
		socialPlatformDao.save(socialPlatform);
		return new SuccessResult("Sosya platform eklendi.");
	}

	
}
