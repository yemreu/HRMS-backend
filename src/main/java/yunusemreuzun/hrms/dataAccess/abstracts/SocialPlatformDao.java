package yunusemreuzun.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import yunusemreuzun.hrms.entities.concretes.SocialPlatform;
import yunusemreuzun.hrms.entities.dtos.SocialPlatformDto;

public interface SocialPlatformDao extends JpaRepository<SocialPlatform, Integer>{

	@Query("SELECT new yunusemreuzun.hrms.entities.dtos.SocialPlatformDto(sp.id,sp.name,sp.url) FROM SocialPlatform sp")
	List<SocialPlatformDto> getSocialPlatformData();
}
