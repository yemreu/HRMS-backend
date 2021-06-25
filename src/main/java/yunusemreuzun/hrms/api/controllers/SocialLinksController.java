package yunusemreuzun.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import yunusemreuzun.hrms.business.abstracts.SocialLinkService;
import yunusemreuzun.hrms.core.utilities.results.DataResult;
import yunusemreuzun.hrms.entities.dtos.SocialLinkDto;

@RestController
@RequestMapping("/api/social-links")
public class SocialLinksController extends Controller{

	private SocialLinkService socialLinkService;

	@Autowired
	public SocialLinksController(SocialLinkService socialLinkService) {
		this.socialLinkService = socialLinkService;
	}
	
	@GetMapping("/get-seeker-cv-social-links")
	public DataResult<List<SocialLinkDto>> getSeekerCvLanguages(@RequestParam int cvId){
		return socialLinkService.getSeekerCvSocialLinks(cvId);
	}
}
