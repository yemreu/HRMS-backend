package yunusemreuzun.hrms.api.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import yunusemreuzun.hrms.business.abstracts.JobTitleService;
import yunusemreuzun.hrms.core.utilities.results.DataResult;
import yunusemreuzun.hrms.entities.concretes.JobTitle;

@RestController
@RequestMapping("/api/job-titles")
public class JobTitlesController extends Controller{

	private JobTitleService jobTitleService;

	@Autowired
	public JobTitlesController(JobTitleService jobTitleService) {
		this.jobTitleService = jobTitleService;
	}
	
	@GetMapping("/get-all")
	public DataResult<List<JobTitle>> getAll(){
		return jobTitleService.getAll();
	}
	
	@PostMapping("/add")
	public ResponseEntity<?> add(@Valid @RequestBody JobTitle jobTitle) {
		return ResponseEntity.ok(jobTitleService.add(jobTitle));
	}
}
