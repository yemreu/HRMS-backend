package yunusemreuzun.hrms.api.controllers;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import yunusemreuzun.hrms.business.abstracts.UserService;
import yunusemreuzun.hrms.core.utilities.results.Result;
import yunusemreuzun.hrms.entities.concretes.User;

@RestController
@RequestMapping("/api/users")
public class UsersController extends Controller{
	
	private UserService userService;

	public UsersController(UserService userService) {
		this.userService = userService;
	}
	
	@PutMapping("/update-email")
	public Result updateEmail(@RequestBody User user) {
		return userService.updateEmail(user.getId(), user.getEmail());
	}
	
	@PutMapping("/update-password")
	public Result updatePassword(@RequestBody User user) {
		return userService.updatePassword(user.getId(), user.getPassword());
	}
}
