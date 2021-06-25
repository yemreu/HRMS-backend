package yunusemreuzun.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import yunusemreuzun.hrms.business.abstracts.CoverLetterService;
import yunusemreuzun.hrms.core.utilities.results.DataResult;
import yunusemreuzun.hrms.core.utilities.results.Result;
import yunusemreuzun.hrms.core.utilities.results.SuccessDataResult;
import yunusemreuzun.hrms.core.utilities.results.SuccessResult;
import yunusemreuzun.hrms.dataAccess.abstracts.CoverLetterDao;
import yunusemreuzun.hrms.entities.concretes.CoverLetter;
import yunusemreuzun.hrms.entities.dtos.CoverLetterDto;

@Service
public class CoverLetterManager implements CoverLetterService{

	private CoverLetterDao coverLetterDao;
	
	@Autowired
	public CoverLetterManager(CoverLetterDao coverLetterDao) {
		this.coverLetterDao = coverLetterDao;
	}

	@Override
	public Result add(CoverLetter coverLetter) {
		coverLetterDao.save(coverLetter);
		return new SuccessResult("Ön yazı eklendi.");
	}

	@Override
	public DataResult<List<CoverLetterDto>> getCoverLetterData(int userId) {
		return new SuccessDataResult<List<CoverLetterDto>>(coverLetterDao.getCoverLetterData(userId));
	}
}
