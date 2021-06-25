package yunusemreuzun.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import yunusemreuzun.hrms.business.abstracts.CvLanguageService;
import yunusemreuzun.hrms.core.utilities.results.DataResult;
import yunusemreuzun.hrms.entities.dtos.CvLanguageDto;

@RestController
@RequestMapping("/api/cv-languages")
public class CvLanguagesController extends Controller{

	private CvLanguageService cvLanguageService;

	@Autowired
	public CvLanguagesController(CvLanguageService cvLanguageService) {
		this.cvLanguageService = cvLanguageService;
	}
	
	@GetMapping("/get-seeker-cv-languages")
	public DataResult<List<CvLanguageDto>> getSeekerCvLanguages(@RequestParam int cvId){
		return cvLanguageService.getSeekerCvLanguages(cvId);
	}
}
