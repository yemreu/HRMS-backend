package yunusemreuzun.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import yunusemreuzun.hrms.entities.concretes.SocialPlatform;

public interface SocialPlatformDao extends JpaRepository<SocialPlatform, Integer>{

}
