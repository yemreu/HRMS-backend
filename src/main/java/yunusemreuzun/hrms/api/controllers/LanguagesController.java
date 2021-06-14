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

import yunusemreuzun.hrms.business.abstracts.LanguageService;
import yunusemreuzun.hrms.core.utilities.results.DataResult;
import yunusemreuzun.hrms.entities.concretes.Language;

@RestController
@RequestMapping("/api/languages")
public class LanguagesController extends Controller{

	private LanguageService languageService;

	@Autowired
	public LanguagesController(LanguageService languageService) {
		this.languageService = languageService;
	}
	
	@PostMapping("/add")
	public ResponseEntity<?> add(@Valid @RequestBody Language language) {
		return ResponseEntity.ok(languageService.add(language));
	}
	
	@GetMapping("/get-all")
	public DataResult<List<Language>> getAll(){
		return languageService.getAll();
	}
}
