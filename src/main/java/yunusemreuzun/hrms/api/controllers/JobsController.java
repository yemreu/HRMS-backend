package yunusemreuzun.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import yunusemreuzun.hrms.business.abstracts.JobService;
import yunusemreuzun.hrms.core.utilities.results.Result;
import yunusemreuzun.hrms.entities.concretes.Job;

@RestController
@RequestMapping("api/jobs")
public class JobsController {

	private JobService jobService;

	@Autowired
	public JobsController(JobService jobService) {
		this.jobService = jobService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody Job job) {
		return jobService.add(job);
	}
}
