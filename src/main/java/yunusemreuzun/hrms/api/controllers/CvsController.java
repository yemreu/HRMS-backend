package yunusemreuzun.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import yunusemreuzun.hrms.business.abstracts.CvService;
import yunusemreuzun.hrms.core.utilities.results.DataResult;
import yunusemreuzun.hrms.core.utilities.results.Result;
import yunusemreuzun.hrms.entities.concretes.Cv;

@RestController
@RequestMapping("/api/cvs/")
public class CvsController {

	private CvService cvService;

	@Autowired
	public CvsController(CvService cvService) {
		this.cvService = cvService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody Cv cv) {
		return cvService.add(cv);
	}
	
	@GetMapping("/get-cvs")
	public DataResult<Cv> getSeekerCvs(@RequestParam int userId) {
		return cvService.getSeekerCvs(userId);
	}
}
