package ilayda.api.controllers;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ilayda.business.abstracts.JobSeekerService;
import ilayda.core.adapters.Verification;
import ilayda.core.utilities.result.*;
import ilayda.entities.concretes.JobSeeker;

@RestController
@RequestMapping("/api/jobseekers")
public class JobSeekerController {

	private JobSeekerService jobSeekerService;
	private Verification verification;

	@Autowired
	public JobSeekerController(JobSeekerService jobSeekerService) {
		super();
		this.jobSeekerService = jobSeekerService;
	}

	@PostMapping("/add")
	public Result add(@RequestBody JobSeeker jobSeeker) throws IOException {
		this.verification = new Verification(jobSeeker);
		
		if (this.verification.isCorrect()) {
			return this.jobSeekerService.add(jobSeeker);
		}
		else {
			return new ErrorResult("Lütfen bilgilerinizi kontrol ediniz.");
		}
	}

	@GetMapping("/getall")
	public DataResult<List<JobSeeker>> getAll() {
		return this.jobSeekerService.getAll();
	}

}
