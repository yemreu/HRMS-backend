package yunusemreuzun.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import yunusemreuzun.hrms.business.abstracts.EducationService;
import yunusemreuzun.hrms.core.utilities.results.DataResult;
import yunusemreuzun.hrms.core.utilities.results.SuccessDataResult;
import yunusemreuzun.hrms.dataAccess.abstracts.EducationDao;
import yunusemreuzun.hrms.entities.dtos.EducationDto;

@Service
public class EducationManager implements EducationService{

private EducationDao educationDao;
	
	@Autowired
	public EducationManager(EducationDao educationDao) {
		this.educationDao = educationDao;
	}

	@Override
	public DataResult<List<EducationDto>> getSeekerCvEducations(int cvId) {
		return new SuccessDataResult<List<EducationDto>>(educationDao.getByCv_Id(cvId));
	}
}
