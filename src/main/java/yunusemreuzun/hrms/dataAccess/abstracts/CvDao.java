package yunusemreuzun.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import yunusemreuzun.hrms.entities.concretes.Cv;

public interface CvDao extends JpaRepository<Cv, Integer>{

	Cv getByJobSeekerUser_Id(int id);
}
