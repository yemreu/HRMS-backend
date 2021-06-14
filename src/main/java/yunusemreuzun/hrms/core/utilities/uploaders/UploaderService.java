package yunusemreuzun.hrms.core.utilities.uploaders;

import java.io.IOException;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

public interface UploaderService {

	Map upload(MultipartFile file) throws IOException;
}

