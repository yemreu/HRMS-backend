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

import yunusemreuzun.hrms.business.abstracts.JobSeekerUserService;
import yunusemreuzun.hrms.core.utilities.results.DataResult;
import yunusemreuzun.hrms.entities.concretes.JobSeekerUser;
import yunusemreuzun.hrms.entities.dtos.JobSeekerUserDto;

@RestController
@RequestMapping("/api/users/job-seekers")
public class JobSeekerUsersController extends Controller{

	private JobSeekerUserService jobSeekerUserService;

	@Autowired
	public JobSeekerUsersController(JobSeekerUserService jobSeekerUserService) {
		this.jobSeekerUserService = jobSeekerUserService;
	}
	
	@PostMapping("/register")
	public ResponseEntity<?> register(@Valid @RequestBody JobSeekerUser jobSeekerUser) {
		return ResponseEntity.ok(jobSeekerUserService.register(jobSeekerUser));
	}
	
	@GetMapping("/get-all")
	public DataResult<List<JobSeekerUserDto>> getAll(){
		return jobSeekerUserService.getJobSeekerUserData();
	}
}
