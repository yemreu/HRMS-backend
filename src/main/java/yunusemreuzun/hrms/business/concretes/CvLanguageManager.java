package yunusemreuzun.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import yunusemreuzun.hrms.business.abstracts.CvLanguageService;
import yunusemreuzun.hrms.core.utilities.results.DataResult;
import yunusemreuzun.hrms.core.utilities.results.SuccessDataResult;
import yunusemreuzun.hrms.dataAccess.abstracts.CvLanguageDao;
import yunusemreuzun.hrms.entities.concretes.CvLanguage;
import yunusemreuzun.hrms.entities.dtos.CvLanguageDto;

@Service
public class CvLanguageManager implements CvLanguageService{
	
	private CvLanguageDao cvLanguageDao;
	
	@Autowired
	public CvLanguageManager(CvLanguageDao cvLanguageDao) {
		this.cvLanguageDao = cvLanguageDao;
	}

	@Override
	public DataResult<List<CvLanguageDto>> getSeekerCvLanguages(int cvId) {
		return new SuccessDataResult<List<CvLanguageDto>>(cvLanguageDao.getByCv_Id(cvId));
	}

}
