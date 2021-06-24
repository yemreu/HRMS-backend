package yunusemreuzun.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import yunusemreuzun.hrms.entities.concretes.Cv;
import yunusemreuzun.hrms.entities.dtos.CvDto;

public interface CvDao extends JpaRepository<Cv, Integer>{

	Cv getByJobSeekerUser_Id(int id);
	
	
	  @Query("SELECT new yunusemreuzun.hrms.entities.dtos.CvDto(c.id,i.imageUrl,cl.title,cl.body,c.skills) FROM Cv c INNER JOIN c.jobSeekerUser js INNER JOIN js.image i INNER JOIN c.coverLetter cl WHERE js.id = :userId"
	  ) CvDto getCvData(int userId);
	 
}



