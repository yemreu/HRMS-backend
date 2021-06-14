package yunusemreuzun.hrms.core.utilities.uploaders.cloudinary;

import java.io.IOException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import com.cloudinary.*;
import com.cloudinary.utils.ObjectUtils;

import yunusemreuzun.hrms.core.utilities.uploaders.UploaderService;

@Component
public class CloudinaryUploader implements UploaderService{

	private Cloudinary cloudinary;
	
	@Autowired
	public CloudinaryUploader(@Value("${cloudinary.cloud-name}") String cloudName,
			@Value("${cloudinary.api-key}") String apiKey,
			@Value("${cloudinary.api-secret}") String apiSecret) {
		this.cloudinary = new Cloudinary(ObjectUtils.asMap("cloud_name", cloudName,
				"api_key", apiKey,
				"api_secret", apiSecret));
	}
	
	public Map upload(MultipartFile file) throws IOException{
		return cloudinary.uploader().upload(file.getBytes(), ObjectUtils.asMap("folder","hrms"));
	}
}
