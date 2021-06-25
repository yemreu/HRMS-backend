package yunusemreuzun.hrms.api.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import yunusemreuzun.hrms.business.abstracts.CoverLetterService;
import yunusemreuzun.hrms.core.utilities.results.DataResult;
import yunusemreuzun.hrms.entities.concretes.CoverLetter;
import yunusemreuzun.hrms.entities.dtos.CoverLetterDto;

@RestController
@RequestMapping("/api/cover-letters")
public class CoverLettersController extends Controller{

	private CoverLetterService coverLetterService;
	
	@Autowired
	public CoverLettersController(CoverLetterService coverLetterService) {
		this.coverLetterService = coverLetterService;
	}

	@PostMapping("/add")
	public ResponseEntity<?> add(@Valid @RequestBody CoverLetter coverLetter) {
		return ResponseEntity.ok(coverLetterService.add(coverLetter));
	}
	
	@GetMapping("/get-job-seeker-cover-letters")
	public DataResult<List<CoverLetterDto>> getCoverLetterData(@RequestParam int userId){
		return coverLetterService.getCoverLetterData(userId);
	}
}
