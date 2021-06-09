package yunusemreuzun.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import yunusemreuzun.hrms.entities.concretes.Job;

public interface JobDao extends JpaRepository<Job, Integer>{

	List<Job> getByActiveTrue();
}
