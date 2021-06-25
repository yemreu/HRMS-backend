package yunusemreuzun.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import yunusemreuzun.hrms.business.abstracts.ExperienceService;
import yunusemreuzun.hrms.core.utilities.results.DataResult;
import yunusemreuzun.hrms.entities.dtos.ExperienceDto;

@RestController
@RequestMapping("/api/experiences")
public class ExperiencesController extends Controller{

	private ExperienceService experienceService;

	@Autowired
	public ExperiencesController(ExperienceService experienceService) {
		this.experienceService = experienceService;
	}
	
	@GetMapping("/get-seeker-cv-experiences")
	public DataResult<List<ExperienceDto>> getSeekerCvEducations(@RequestParam int cvId){
		return experienceService.getSeekerCvExperiences(cvId);
	}
}
