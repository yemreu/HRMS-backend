package yunusemreuzun.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import yunusemreuzun.hrms.entities.concretes.City;
import yunusemreuzun.hrms.entities.dtos.CityDto;

public interface CityDao extends JpaRepository<City, Integer>{

	@Query("SELECT new yunusemreuzun.hrms.entities.dtos.CityDto(c.code,c.name) FROM City c")
	List<CityDto> getCityData();
}
