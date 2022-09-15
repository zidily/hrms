package ilayda.business.abstracts;

import java.util.List;

import ilayda.core.utilities.result.*;
import ilayda.entities.concretes.JobSeeker;

public interface JobSeekerService {

	
	DataResult<List<JobSeeker>> getAll();
	Result add(JobSeeker jobseeker); 
}
