package yunusemreuzun.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import yunusemreuzun.hrms.entities.concretes.SocialLink;

public interface SocialLinkDao extends JpaRepository<SocialLink, Integer>{

}
