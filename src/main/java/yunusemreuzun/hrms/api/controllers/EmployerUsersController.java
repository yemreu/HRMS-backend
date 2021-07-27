package yunusemreuzun.hrms.api.controllers;

import java.util.List;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import yunusemreuzun.hrms.business.abstracts.EmployerUserService;
import yunusemreuzun.hrms.core.utilities.results.DataResult;
import yunusemreuzun.hrms.core.utilities.results.Result;
import yunusemreuzun.hrms.entities.concretes.EmployerUser;
import yunusemreuzun.hrms.entities.concretes.EmployerUserProfileUpdate;
import yunusemreuzun.hrms.entities.dtos.EmployerUserDto;
import yunusemreuzun.hrms.entities.dtos.EmployerUserProfileUpdateDto;

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
	
	@PutMapping("/verify")
	public Result verify(Integer companyId) {
		return employerUserService.verify(companyId);
	}
	
	@GetMapping("/get-all")
	public DataResult<List<EmployerUserDto>> getAll(){
		return employerUserService.getAllEmployerUserData();
	}
	
	@GetMapping("/get-employer-user")
	public DataResult<EmployerUserDto> getEmployerUser(@RequestParam int userId){
		return employerUserService.getEmployerUserData(userId);
	}
	
	@PostMapping("update-employer-profile")
	public Result update(@RequestBody EmployerUserProfileUpdate employerUserProfileUpdate) {
		return employerUserService.update(employerUserProfileUpdate);
	}
	
	@GetMapping("/get-employer-profile-update")
	public DataResult<EmployerUserProfileUpdateDto> getEmployerProfileUpdate(@RequestParam int id){
		return employerUserService.getEmployerProfileUpdateData(id);
	}
	
	@GetMapping("/get-employer-profile-updates")
	public DataResult<List<EmployerUserProfileUpdateDto>> getEmployerUserProfileUpdatesData(){
		return employerUserService.getEmployerUserProfileUpdatesData();
	}
	
	@PutMapping("approve-profile-update")
	public Result approveProfileUpdate(@RequestParam int profileUpdateId) {
		return employerUserService.approveProfileUpdate(profileUpdateId);
	}
	
	@GetMapping("/exists-employer-profile-update")
	public Result existsEmployerProfileUpdate(@RequestParam int userId){
		return employerUserService.existsEmployerProfileUpdate(userId);
	}
}
