package yunusemreuzun.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import yunusemreuzun.hrms.business.abstracts.LanguageService;
import yunusemreuzun.hrms.core.utilities.results.DataResult;
import yunusemreuzun.hrms.core.utilities.results.Result;
import yunusemreuzun.hrms.core.utilities.results.SuccessDataResult;
import yunusemreuzun.hrms.core.utilities.results.SuccessResult;
import yunusemreuzun.hrms.dataAccess.abstracts.LanguageDao;
import yunusemreuzun.hrms.entities.concretes.Language;
import yunusemreuzun.hrms.entities.dtos.LanguageDto;

@Service
public class LanguageManager implements LanguageService{

	private LanguageDao languageDao;

	@Autowired
	public LanguageManager(LanguageDao languageDao) {
		this.languageDao = languageDao;
	}

	@Override
	public Result add(Language language) {
		languageDao.save(language);
		return new SuccessResult("Yeni dil eklendi.");
	}

	@Override
	public DataResult<List<LanguageDto>> getAll() {
		return new SuccessDataResult<List<LanguageDto>>(languageDao.getLanguageData(),"Tüm diller listelendi.");
	}
	
	
}
