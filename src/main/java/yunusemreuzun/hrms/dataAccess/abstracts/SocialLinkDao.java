package yunusemreuzun.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import yunusemreuzun.hrms.entities.concretes.SocialLink;
import yunusemreuzun.hrms.entities.dtos.SocialLinkDto;

public interface SocialLinkDao extends JpaRepository<SocialLink, Integer>{

	@Query("SELECT new yunusemreuzun.hrms.entities.dtos.SocialLinkDto(sl.id,sp.url,sl.profileName) FROM SocialLink sl INNER JOIN sl.socialPlatform sp INNER JOIN sl.cv c WHERE c.id = :cvId")
	List<SocialLinkDto> getByCv_Id(int cvId);
}
