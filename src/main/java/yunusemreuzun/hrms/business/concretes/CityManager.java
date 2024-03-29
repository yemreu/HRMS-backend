package yunusemreuzun.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import yunusemreuzun.hrms.business.abstracts.CityService;
import yunusemreuzun.hrms.core.utilities.results.DataResult;
import yunusemreuzun.hrms.core.utilities.results.SuccessDataResult;
import yunusemreuzun.hrms.dataAccess.abstracts.CityDao;
import yunusemreuzun.hrms.entities.dtos.CityDto;

@Service
public class CityManager implements CityService{
	
	private CityDao cityDao;
	
	@Autowired
	public CityManager(CityDao cityDao) {
		this.cityDao = cityDao;
	}

	@Override
	public DataResult<List<CityDto>> getAll() {
		return new SuccessDataResult<List<CityDto>>(cityDao.getCityData(), "Tüm şehirler listelendi");
	}

}
