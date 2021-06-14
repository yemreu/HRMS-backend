package yunusemreuzun.hrms.api.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import yunusemreuzun.hrms.business.abstracts.JobSeekerUserService;
import yunusemreuzun.hrms.core.utilities.results.DataResult;
import yunusemreuzun.hrms.core.utilities.results.Result;
import yunusemreuzun.hrms.entities.concretes.JobSeekerUser;

@RestController
@RequestMapping("/api/users/job-seekers")
public class JobSeekerUsersController extends Controller{

	private JobSeekerUserService jobSeekerUserService;

	@Autowired
	public JobSeekerUsersController(JobSeekerUserService jobSeekerUserService) {
		this.jobSeekerUserService = jobSeekerUserService;
	}
	
	@PostMapping("/register")
	public Result register(@Valid @RequestBody JobSeekerUser jobSeekerUser) {
		return jobSeekerUserService.register(jobSeekerUser);
	}
	
	@GetMapping("/get-all")
	public DataResult<List<JobSeekerUser>> getAll(){
		return jobSeekerUserService.getAll();
	}
}
