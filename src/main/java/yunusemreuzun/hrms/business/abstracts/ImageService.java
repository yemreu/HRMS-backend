package yunusemreuzun.hrms.business.abstracts;

import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import yunusemreuzun.hrms.core.utilities.results.DataResult;

public interface ImageService {

	DataResult<Map<String, String>> upload(MultipartFile multipartFile, int userId, String alt);
}
