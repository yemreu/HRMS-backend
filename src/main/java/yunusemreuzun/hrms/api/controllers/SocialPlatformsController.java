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

import yunusemreuzun.hrms.business.abstracts.SocialPlatformService;
import yunusemreuzun.hrms.core.utilities.results.DataResult;
import yunusemreuzun.hrms.entities.concretes.SocialPlatform;

@RestController
@RequestMapping("/api/social-platforms")
public class SocialPlatformsController extends Controller{

	private SocialPlatformService socialPlatformService;

	@Autowired
	public SocialPlatformsController(SocialPlatformService socialPlatformService) {
		this.socialPlatformService = socialPlatformService;
	}
	
	@GetMapping("/get-all")
	public DataResult<List<SocialPlatform>> getAll(){
		return socialPlatformService.getAll();
	}
	
	@PostMapping("/add")
	public ResponseEntity<?> add(@Valid @RequestBody SocialPlatform socialPlatform) {
		return ResponseEntity.ok(socialPlatformService.add(socialPlatform));
	}
}
