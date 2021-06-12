package yunusemreuzun.hrms.adapters;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import org.springframework.stereotype.Component;

import yunusemreuzun.hrms.core.utilities.uploaders.cloudinary.CloudinaryUploader;

@Component
public class ImageServiceAdapter{

	public Map upload(File file) throws IOException {
		CloudinaryUploader uploader = new CloudinaryUploader();
		return uploader.upload(file);
	}

}
