package yunusemreuzun.hrms.api.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import yunusemreuzun.hrms.business.abstracts.ImageService;
import yunusemreuzun.hrms.core.utilities.results.DataResult;

@RestController
@RequestMapping("/api/images")
public class ImagesController extends Controller{

	private ImageService imageService;

	@Autowired
	public ImagesController(ImageService imageService) {
		this.imageService = imageService;
	}
	
	@PostMapping("/upload")
	public DataResult<Map<String, String>> upload(@RequestBody MultipartFile multiPartFile, @RequestParam int userId,@RequestParam(required = false) String alt){
		return imageService.upload(multiPartFile,userId,alt);
	}
}
