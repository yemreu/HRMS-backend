package yunusemreuzun.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import yunusemreuzun.hrms.business.abstracts.ExperienceService;
import yunusemreuzun.hrms.core.utilities.results.DataResult;
import yunusemreuzun.hrms.core.utilities.results.SuccessDataResult;
import yunusemreuzun.hrms.dataAccess.abstracts.ExperienceDao;
import yunusemreuzun.hrms.entities.dtos.ExperienceDto;

@Service
public class ExperienceManager implements ExperienceService{

private ExperienceDao experienceDao;
	
	@Autowired
	public ExperienceManager(ExperienceDao experienceDao) {
		this.experienceDao = experienceDao;
	}

	@Override
	public DataResult<List<ExperienceDto>> getSeekerCvExperiences(int cvId) {
		return new SuccessDataResult<List<ExperienceDto>>(experienceDao.getByCv_Id(cvId));
	}
}
