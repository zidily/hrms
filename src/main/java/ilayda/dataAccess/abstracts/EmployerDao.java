package ilayda.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import ilayda.entities.concretes.Employer;

public interface EmployerDao extends JpaRepository<Employer, Integer> {

}
