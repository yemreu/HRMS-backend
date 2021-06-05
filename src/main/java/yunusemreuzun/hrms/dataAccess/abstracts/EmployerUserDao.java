package yunusemreuzun.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import yunusemreuzun.hrms.dataAccess.abstracts.projections.IdOnly;
import yunusemreuzun.hrms.entities.concretes.EmployerUser;

public interface EmployerUserDao extends JpaRepository<EmployerUser, Integer>{

	boolean existsByEmail(String email);
	List<IdOnly> findByEmail(String email);
	EmployerUser findById(int id);
}
