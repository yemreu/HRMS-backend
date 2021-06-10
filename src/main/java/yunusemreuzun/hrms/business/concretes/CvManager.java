package yunusemreuzun.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import yunusemreuzun.hrms.business.abstracts.CvService;
import yunusemreuzun.hrms.core.utilities.results.DataResult;
import yunusemreuzun.hrms.core.utilities.results.Result;
import yunusemreuzun.hrms.core.utilities.results.SuccessDataResult;
import yunusemreuzun.hrms.core.utilities.results.SuccessResult;
import yunusemreuzun.hrms.dataAccess.abstracts.CvDao;
import yunusemreuzun.hrms.entities.concretes.Cv;

@Service
public class CvManager implements CvService{

	private CvDao cvDao;
	
	@Autowired
	public CvManager(CvDao cvDao) {
		this.cvDao = cvDao;
	}

	@Override
	public Result add(Cv cv) {
		cv.getEducations().forEach(education -> education.setCv(cv));
		cvDao.save(cv);
		return new SuccessResult("Cv kaydedildi.");
	}

	@Override
	public DataResult<Cv> getSeekerCvs(int id) {
		return new SuccessDataResult<Cv>(cvDao.getByJobSeekerUser_Id(id), "İş arayanın cvleri listelendi.");
	}

}
