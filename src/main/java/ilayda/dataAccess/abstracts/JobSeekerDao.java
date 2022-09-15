package ilayda.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import ilayda.entities.concretes.JobSeeker;


public interface JobSeekerDao extends JpaRepository<JobSeeker, Integer>{

}
