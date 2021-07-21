package yunusemreuzun.hrms.api.controllers;

import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import yunusemreuzun.hrms.business.abstracts.JobService;
import yunusemreuzun.hrms.core.utilities.results.DataResult;
import yunusemreuzun.hrms.core.utilities.results.Result;
import yunusemreuzun.hrms.entities.concretes.Job;
import yunusemreuzun.hrms.entities.dtos.JobDto;

@RestController
@RequestMapping("/api/jobs")
public class JobsController extends Controller{

	private JobService jobService;

	@Autowired
	public JobsController(JobService jobService) {
		this.jobService = jobService;
	}

	@PostMapping("/add")
	public ResponseEntity<?> add(@Valid @RequestBody @DateTimeFormat(iso = ISO.DATE) Job job) {
		return ResponseEntity.ok(jobService.add(job));
	}

	@GetMapping("/get-active-jobs")
	public DataResult<List<JobDto>> getActiveJobs() {
		return jobService.getActiveJobData();
	}
	
	@GetMapping("/get-inactive-jobs")
	public DataResult<List<JobDto>> getInActiveJobs() {
		return jobService.getInActiveJobData();
	}

	@GetMapping("/get-employer-active-jobs")
	public DataResult<List<JobDto>> getEmployerActiveJobs(@RequestParam int userId) {
		return jobService.getEmployerActiveJobData(userId);
	}

	@GetMapping("/get-active-jobs-with-last-application-date")
	public DataResult<List<JobDto>> getActiveJobsWithLastApplicationDate(@RequestParam @DateTimeFormat(iso = ISO.DATE) LocalDate date) {
		return jobService.getActiveJobByLastApplicationDateData(date);
	}
	
	@PutMapping("/activate-job")
	public Result activateJob(Integer id) {
		return jobService.activateJob(id);
	}
	
	@PutMapping("/deactivate-job")
	public Result deactivateJob(Integer id) {
		return jobService.deactivateJob(id);
	}

}
