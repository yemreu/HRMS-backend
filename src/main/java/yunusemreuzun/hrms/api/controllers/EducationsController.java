package yunusemreuzun.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import yunusemreuzun.hrms.business.abstracts.EducationService;
import yunusemreuzun.hrms.core.utilities.results.DataResult;
import yunusemreuzun.hrms.entities.dtos.EducationDto;

@RestController
@RequestMapping("/api/educations")
public class EducationsController extends Controller{

	private EducationService educationService;

	@Autowired
	public EducationsController(EducationService educationService) {
		this.educationService = educationService;
	}
	
	@GetMapping("/get-seeker-cv-educations")
	public DataResult<List<EducationDto>> getSeekerCvEducations(@RequestParam int cvId){
		return educationService.getSeekerCvEducations(cvId);
	}
}
