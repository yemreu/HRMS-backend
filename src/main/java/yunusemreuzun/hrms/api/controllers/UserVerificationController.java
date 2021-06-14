package yunusemreuzun.hrms.api.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import yunusemreuzun.hrms.business.abstracts.UserVerificationService;

@RestController
@RequestMapping("/api/users")
public class UserVerificationController extends Controller{

	private UserVerificationService userVerificationService;

	@Autowired
	public UserVerificationController(UserVerificationService userVerificationService) {
		this.userVerificationService = userVerificationService;
	}
	
	@PostMapping("/verify")
	public ResponseEntity<?> verify(@Valid @RequestBody String token) {
		return ResponseEntity.ok(userVerificationService.verify(token));
	}
}
