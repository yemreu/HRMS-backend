package yunusemreuzun.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import yunusemreuzun.hrms.business.abstracts.UserVerificationService;
import yunusemreuzun.hrms.core.utilities.results.Result;

@RestController
@RequestMapping("/api/users")
public class UserVerificationController {

	private UserVerificationService userVerificationService;

	@Autowired
	public UserVerificationController(UserVerificationService userVerificationService) {
		this.userVerificationService = userVerificationService;
	}
	
	@PostMapping("/verify")
	public Result verify(@RequestBody String token) {
		return userVerificationService.verify(token);
	}
}
