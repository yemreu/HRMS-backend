package yunusemreuzun.hrms.business.concretes;

import java.io.IOException;
import java.util.HashMap;
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
import yunusemreuzun.hrms.dataAccess.abstracts.UserDao;
import yunusemreuzun.hrms.entities.concretes.Image;
import yunusemreuzun.hrms.entities.concretes.User;

@Service
public class ImageManager implements ImageService{

	private ImageDao imageDao;
	private UserDao userDao;
	private ImageServiceAdapter imageServiceAdapter;
	
	@Autowired
	public ImageManager(ImageDao imageDao, ImageServiceAdapter imageServiceAdapter,UserDao userDao) {
		this.imageDao = imageDao;
		this.imageServiceAdapter = imageServiceAdapter;
		this.userDao = userDao;
	}

	@Override
	public DataResult<Map<String, String>> upload(MultipartFile multiPartFile, int userId, String alt) {
		try {
			String imageUrl = imageServiceAdapter.upload(multiPartFile).get("url").toString();
			User user = userDao.getById(userId);
			Image image;
			if(imageDao.existsImageByUser_Id(userId)) {
				image = imageDao.findByUser_Id(userId);
				image.setAlt(alt);
				image.setImageUrl(imageUrl);
			}else {
				image = new Image(0, imageUrl, alt, user);
			}
			imageDao.save(image);
			Map<String,String> results = new HashMap<>();
			results.put("image_url", imageUrl);
			results.put("alt", image.getAlt());
			return new SuccessDataResult<Map<String,String>>(results, "Fotoğraf yüklendi.");
		}catch (IOException e) {
			return new ErrorDataResult<>(e.getMessage());
		}
	}

}
