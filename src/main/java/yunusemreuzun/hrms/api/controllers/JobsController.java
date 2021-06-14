package yunusemreuzun.hrms.api.controllers;

import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import yunusemreuzun.hrms.business.abstracts.JobService;
import yunusemreuzun.hrms.core.utilities.results.DataResult;
import yunusemreuzun.hrms.core.utilities.results.Result;
import yunusemreuzun.hrms.entities.concretes.Job;

@RestController
@RequestMapping("/api/jobs")
public class JobsController extends Controller{

	private JobService jobService;

	@Autowired
	public JobsController(JobService jobService) {
		this.jobService = jobService;
	}

	@PostMapping("/add")
	public Result add(@Valid @RequestBody @DateTimeFormat(iso = ISO.DATE) Job job) {
		return jobService.add(job);
	}

	@GetMapping("/get-active-jobs")
	public DataResult<List<Job>> getActiveJobs() {
		return jobService.getActiveJobs();
	}

	@GetMapping("/get-employer-active-jobs")
	public DataResult<List<Job>> getEmployerActiveJobs(@RequestParam int userId) {
		return jobService.getEmployerActiveJobs(userId);
	}

	@GetMapping("/get-active-jobs-with-last-application-date")
	public DataResult<List<Job>> getActiveJobsWithLastApplicationDate(@RequestParam @DateTimeFormat(iso = ISO.DATE) LocalDate date) {
		return jobService.getActiveJobsWithLastApplicationDate(date);
	}
	
	@PostMapping("/deactivate-job")
	public Result deactivateJob(@RequestParam int id) {
		return jobService.deactivateJob(id);
	}

}
