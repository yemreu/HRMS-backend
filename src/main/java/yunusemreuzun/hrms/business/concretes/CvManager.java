package yunusemreuzun.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import yunusemreuzun.hrms.business.abstracts.CvService;
import yunusemreuzun.hrms.core.utilities.results.DataResult;
import yunusemreuzun.hrms.core.utilities.results.Result;
import yunusemreuzun.hrms.core.utilities.results.SuccessDataResult;
import yunusemreuzun.hrms.core.utilities.results.SuccessResult;
import yunusemreuzun.hrms.dataAccess.abstracts.CoverLetterDao;
import yunusemreuzun.hrms.dataAccess.abstracts.CvDao;
import yunusemreuzun.hrms.entities.concretes.CoverLetter;
import yunusemreuzun.hrms.entities.concretes.Cv;
import yunusemreuzun.hrms.entities.dtos.CvDto;

@Service
public class CvManager implements CvService{

	private CvDao cvDao;
	private CoverLetterDao coverLetterDao;
	
	@Autowired
	public CvManager(CvDao cvDao,CoverLetterDao coverLetterDao) {
		this.cvDao = cvDao;
		this.coverLetterDao = coverLetterDao;
	}

	@Override
	public Result save(Cv cv) {
		cv.getEducations().forEach(education -> education.setCv(cv));
		cv.getExperiences().forEach(experience -> experience.setCv(cv));
		cv.getLanguages().forEach(language -> language.setCv(cv));
		cv.getSocialLinks().forEach(socialLink -> socialLink.setCv(cv));
		cvDao.save(cv);
		return new SuccessResult("Cv kaydedildi.");
	}

	@Override
	public DataResult<Cv> getSeekerCv(int id) {
		return new SuccessDataResult<Cv>(cvDao.getByJobSeekerUser_Id(id), "İş arayanın cv'si listelendi.");
	}

	@Override
	public Result selectCoverLetter(int userId, int coverId) {
		Cv cv = cvDao.getByJobSeekerUser_Id(userId);
		CoverLetter coverLetter = coverLetterDao.getById(coverId);
		cv.setCoverLetter(coverLetter);
		cvDao.save(cv);
		return new SuccessResult("Ön yazı seçildi");
	}

	
	  @Override 
	  public DataResult<CvDto> getSeekerCvData(int userId) { 
		  return new SuccessDataResult<CvDto>(cvDao.getCvData(userId),"İş arayanın cv'si listelendi."); 
	  }
	 

}
