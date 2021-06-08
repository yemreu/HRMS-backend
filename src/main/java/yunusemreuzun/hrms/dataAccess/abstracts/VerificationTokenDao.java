package yunusemreuzun.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import yunusemreuzun.hrms.dataAccess.abstracts.projections.UserIdOnly;
import yunusemreuzun.hrms.entities.concretes.VerificationToken;

public interface VerificationTokenDao extends JpaRepository<VerificationToken, Integer>{

	List<UserIdOnly> getByToken(String token);
}
