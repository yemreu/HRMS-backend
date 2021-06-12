package yunusemreuzun.hrms.business.concretes;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import yunusemreuzun.hrms.adapters.ImageServiceAdapter;
import yunusemreuzun.hrms.business.abstracts.ImageService;
import yunusemreuzun.hrms.core.utilities.results.DataResult;
import yunusemreuzun.hrms.core.utilities.results.ErrorDataResult;
import yunusemreuzun.hrms.core.utilities.results.SuccessDataResult;
import yunusemreuzun.hrms.dataAccess.abstracts.ImageDao;

@Service
public class ImageManager implements ImageService{

	private ImageDao imageDao;
	private ImageServiceAdapter imageServiceAdapter;
	
	@Autowired
	public ImageManager(ImageDao imageDao, ImageServiceAdapter imageServiceAdapter) {
		this.imageDao = imageDao;
		this.imageServiceAdapter = imageServiceAdapter;
	}

	@Override
	public DataResult<Map> upload(MultipartFile multiPartFile) {
		try {
			File file = new File(multiPartFile.getOriginalFilename());
			FileOutputStream stream = new FileOutputStream(file);
			stream.write(multiPartFile.getBytes());
			stream.close();
			Map result = imageServiceAdapter.upload(file);
			return new SuccessDataResult<Map>(result, "Fotoğraf yüklendi.");
		}catch (IOException e) {
			return new ErrorDataResult<Map>(e.getMessage());
		}
	}

}
