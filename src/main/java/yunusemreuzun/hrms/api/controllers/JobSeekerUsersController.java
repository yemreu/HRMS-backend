package yunusemreuzun.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import yunusemreuzun.hrms.business.abstracts.JobSeekerUserService;
import yunusemreuzun.hrms.core.utilities.results.Result;
import yunusemreuzun.hrms.entities.concretes.JobSeekerUser;

@RestController
@RequestMapping("/api/users/job-seekers")
public class JobSeekerUsersController {

	private JobSeekerUserService jobSeekerUserService;

	@Autowired
	public JobSeekerUsersController(JobSeekerUserService jobSeekerUserService) {
		this.jobSeekerUserService = jobSeekerUserService;
	}
	
	@PostMapping("/register")
	public Result register(@RequestBody JobSeekerUser jobSeekerUser) {
		return jobSeekerUserService.register(jobSeekerUser);
	}
}
