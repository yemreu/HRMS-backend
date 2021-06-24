package yunusemreuzun.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import yunusemreuzun.hrms.entities.concretes.Education;

public interface EducationDao extends JpaRepository<Education, Integer>{

}
