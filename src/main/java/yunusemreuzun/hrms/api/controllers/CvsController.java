package yunusemreuzun.hrms.api.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.http.ResponseEntity;
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
import yunusemreuzun.hrms.entities.dtos.CvDto;

@RestController
@RequestMapping("/api/cvs/")
public class CvsController extends Controller{

	private CvService cvService;

	@Autowired
	public CvsController(CvService cvService) {
		this.cvService = cvService;
	}
	
	@PostMapping("/save")
	public ResponseEntity<?> save(@Valid @RequestBody @DateTimeFormat(iso = ISO.DATE) Cv cv) {
		return ResponseEntity.ok(cvService.save(cv));
	}
	
	@GetMapping("/get-cv")
	public DataResult<CvDto> getSeekerCv(@RequestParam int userId) {
		return cvService.getSeekerCvData(userId);
	}
	
	@GetMapping("/select-cover-letter")
	public Result selectCoverLetter(@RequestParam int userId,@RequestParam int coverId) {
		return cvService.selectCoverLetter(userId, coverId);
	}
}
