package ilayda.business.abstracts;

import java.util.List;

import ilayda.core.utilities.result.*;
import ilayda.entities.concretes.Employer;

public interface EmployerService {
	DataResult<List<Employer>> getAll();
	Result add(Employer employer);
}
