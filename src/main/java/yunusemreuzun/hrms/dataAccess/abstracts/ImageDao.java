package yunusemreuzun.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import yunusemreuzun.hrms.entities.concretes.Image;

public interface ImageDao extends JpaRepository<Image, Integer>{

	boolean existsImageByUser_Id(int user_id);
	
	Image findByUser_Id(int userId);
}
