package yunusemreuzun.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import yunusemreuzun.hrms.business.abstracts.CityService;
import yunusemreuzun.hrms.core.utilities.results.DataResult;
import yunusemreuzun.hrms.entities.concretes.City;

@RestController
@RequestMapping("/api/cities")
public class CitiesController {

	private CityService cityService;

	@Autowired
	public CitiesController(CityService cityService) {
		this.cityService = cityService;
	}
	
	@GetMapping("/get-all")
	public DataResult<List<City>> getAll(){
		return cityService.getAll();
	}
}
