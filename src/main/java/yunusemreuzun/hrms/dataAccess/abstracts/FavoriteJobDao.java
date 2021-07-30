package yunusemreuzun.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import yunusemreuzun.hrms.entities.concretes.FavoriteJob;

public interface FavoriteJobDao extends JpaRepository<FavoriteJob, Integer>{

}
