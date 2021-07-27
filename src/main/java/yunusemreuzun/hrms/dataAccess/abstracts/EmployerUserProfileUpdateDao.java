package yunusemreuzun.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import yunusemreuzun.hrms.entities.concretes.EmployerUserProfileUpdate;
import yunusemreuzun.hrms.entities.dtos.EmployerUserProfileUpdateDto;

public interface EmployerUserProfileUpdateDao extends JpaRepository<EmployerUserProfileUpdate, Integer>{

	EmployerUserProfileUpdate getByEmployerUser_Id(int userId);
	boolean existsByEmployerUser_Id(int userId);
	
	@Query("SELECT new yunusemreuzun.hrms.entities.dtos.EmployerUserProfileUpdateDto(e.id,eu.id,e.companyName,e.website,e.phoneNumber) FROM  EmployerUserProfileUpdate e INNER JOIN e.employerUser eu WHERE e.id=:id")
	EmployerUserProfileUpdateDto getEmployerUserProfileUpdateData(int id);
	
	@Query("SELECT new yunusemreuzun.hrms.entities.dtos.EmployerUserProfileUpdateDto(e.id,eu.id,e.companyName,e.website,e.phoneNumber) FROM  EmployerUserProfileUpdate e INNER JOIN e.employerUser eu")
	List<EmployerUserProfileUpdateDto> getEmployerUserProfileUpdatesData();
}
