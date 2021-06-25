package yunusemreuzun.hrms.business.abstracts;

import java.util.List;

import yunusemreuzun.hrms.core.utilities.results.DataResult;
import yunusemreuzun.hrms.entities.dtos.CityDto;

public interface CityService {

	DataResult<List<CityDto>> getAll();
}
