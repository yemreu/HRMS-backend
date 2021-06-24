package yunusemreuzun.hrms.api.controllers;

import java.util.List;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import yunusemreuzun.hrms.business.abstracts.EmployerUserService;
import yunusemreuzun.hrms.core.utilities.results.DataResult;
import yunusemreuzun.hrms.core.utilities.results.Result;
import yunusemreuzun.hrms.entities.concretes.EmployerUser;
import yunusemreuzun.hrms.entities.dtos.EmployerUserDto;

@RestController
@RequestMapping("/api/users/employers")
public class EmployerUsersController extends Controller{

	private EmployerUserService employerUserService;

	@Autowired
	public EmployerUsersController(EmployerUserService employerUserService) {
		this.employerUserService = employerUserService;
	}
	
	@PostMapping("/register")
	public ResponseEntity<?> register(@Valid @RequestBody EmployerUser employerUser) {
		return ResponseEntity.ok(employerUserService.register(employerUser));
	}
	
	@PostMapping("/verify")
	public Result verify(@RequestBody int companyId) {
		return employerUserService.verify(companyId);
	}
	
	@GetMapping("/get-all")
	public DataResult<List<EmployerUserDto>> getAll(){
		return employerUserService.getEmployerUserData();
	}
}
