package yunusemreuzun.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import yunusemreuzun.hrms.dataAccess.abstracts.projections.IdOnly;
import yunusemreuzun.hrms.entities.concretes.EmployerUser;
import yunusemreuzun.hrms.entities.dtos.EmployerUserDto;

public interface EmployerUserDao extends JpaRepository<EmployerUser, Integer>{

	boolean existsByEmail(String email);
	List<IdOnly> getByEmail(String email);
	
	@Query("SELECT new yunusemreuzun.hrms.entities.dtos.EmployerUserDto(e.id,e.companyName,e.email,e.phoneNumber,e.website,e.verifiedCompany,e.active) FROM  EmployerUser e")
	List<EmployerUserDto> getAllEmployerUserData();
	
	@Query("SELECT new yunusemreuzun.hrms.entities.dtos.EmployerUserDto(e.id,e.companyName,e.email,e.phoneNumber,e.website,e.verifiedCompany,e.active) FROM  EmployerUser e WHERE e.id = :userId")
	EmployerUserDto getEmployerUserData(int userId);
}
