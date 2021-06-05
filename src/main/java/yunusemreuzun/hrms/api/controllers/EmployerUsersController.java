package yunusemreuzun.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import yunusemreuzun.hrms.business.abstracts.EmployerUserService;
import yunusemreuzun.hrms.core.utilities.results.DataResult;
import yunusemreuzun.hrms.core.utilities.results.Result;
import yunusemreuzun.hrms.entities.concretes.EmployerUser;

@RestController
@RequestMapping("/api/users/employers")
public class EmployerUsersController {

	private EmployerUserService employerUserService;

	@Autowired
	public EmployerUsersController(EmployerUserService employerUserService) {
		this.employerUserService = employerUserService;
	}
	
	@PostMapping("/register")
	public Result register(@RequestBody EmployerUser employerUser) {
		return employerUserService.register(employerUser);
	}
	
	@PostMapping("/verify")
	public Result verify(@RequestBody int companyId) {
		return employerUserService.verify(companyId);
	}
	
	@GetMapping("/get-all")
	public DataResult<List<EmployerUser>> getAll(){
		return employerUserService.getAll();
	}
}
