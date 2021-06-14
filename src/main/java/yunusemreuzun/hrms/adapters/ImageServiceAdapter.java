package yunusemreuzun.hrms.adapters;

import java.io.IOException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import yunusemreuzun.hrms.core.utilities.uploaders.UploaderService;

@Component
public class ImageServiceAdapter{

	private UploaderService uploader;
	
	@Autowired
	public ImageServiceAdapter(UploaderService uploader) {
		this.uploader = uploader;
	}

	public Map upload(MultipartFile file) throws IOException {
		return uploader.upload(file);
	}

}
