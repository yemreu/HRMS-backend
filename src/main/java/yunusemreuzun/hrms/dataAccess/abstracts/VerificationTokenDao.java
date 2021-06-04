package yunusemreuzun.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import yunusemreuzun.hrms.entities.concretes.VerificationToken;

public interface VerificationTokenDao extends JpaRepository<VerificationToken, Integer>{

}
