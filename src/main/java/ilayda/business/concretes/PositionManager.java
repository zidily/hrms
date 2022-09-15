package ilayda.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ilayda.business.abstracts.PositionService;
import ilayda.core.utilities.result.*;
import ilayda.dataAccess.abstracts.PositionDao;
import ilayda.entities.concretes.Position;

@Service
public class PositionManager implements PositionService {

	private PositionDao positionDao;

	@Autowired
	public PositionManager(PositionDao positionDao) {
		this.positionDao = positionDao;
	}

	@Override
	public DataResult<List<Position>> getAll() {
		return new SuccessDataResult<List<Position>>(this.positionDao.findAll(), "job seekers listed.");
	}

	@Override
	public Result add(Position position) {
		this.positionDao.save(position);
		return null;
	}

}
