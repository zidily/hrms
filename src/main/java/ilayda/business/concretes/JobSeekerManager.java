package ilayda.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ilayda.business.abstracts.JobSeekerService;
import ilayda.core.utilities.result.*;
import ilayda.dataAccess.abstracts.JobSeekerDao;
import ilayda.entities.concretes.JobSeeker;

@Service
public class JobSeekerManager implements JobSeekerService {

	private JobSeekerDao jobSeekerDao;

	@Autowired
	public JobSeekerManager(JobSeekerDao jobSeekerDao) {
		this.jobSeekerDao = jobSeekerDao;
	}

	@Override
	public DataResult<List<JobSeeker>> getAll() {
		return new SuccessDataResult<List<JobSeeker>>(this.jobSeekerDao.findAll(), "job seekers listed.");
	}

	@Override
	public Result add(JobSeeker jobseeker) {
		this.jobSeekerDao.save(jobseeker);
		return new SuccessResult("işveren eklendi");
	}

}
