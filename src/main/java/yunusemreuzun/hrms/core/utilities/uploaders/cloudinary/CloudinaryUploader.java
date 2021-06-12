package yunusemreuzun.hrms.core.utilities.uploaders.cloudinary;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.cloudinary.*;
import com.cloudinary.utils.ObjectUtils;

@Component
public class CloudinaryUploader {

	private Cloudinary cloudinary;
	
	@Value("${cloudinary.cloud-name}")
	private String cloudName;
	
	@Value("${cloudinary.api-key}")
	private String apiKey;
	
	@Value("${cloudinary.api-secret}")
	private String apiSecret;
	
	public CloudinaryUploader() {
		this.cloudinary = new Cloudinary(ObjectUtils.asMap("cloud_name", cloudName,
				"api_key", apiKey,
				"api_secret", apiSecret));
	}
	
	public Map upload(File file) throws IOException{
		return cloudinary.uploader().upload(file, ObjectUtils.emptyMap());
	}
}
