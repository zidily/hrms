package ilayda.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ilayda.business.abstracts.EmployerService;
import ilayda.core.utilities.result.*;
import ilayda.dataAccess.abstracts.EmployerDao;
import ilayda.entities.concretes.Employer;

@Service
public class EmployerManager implements EmployerService {

	private EmployerDao employerdao;

	@Autowired
	public EmployerManager(EmployerDao employerdao) {
		this.employerdao = employerdao;

	}

	@Override
	public DataResult<List<Employer>> getAll() {
		return new SuccessDataResult<List<Employer>>(this.employerdao.findAll(), "employers listed.");
	}

	@Override
	public Result add(Employer employer) {
		this.employerdao.save(employer);
		return new SuccessResult("employer saved.");
	}

}
