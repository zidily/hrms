package ilayda.business.abstracts;

import java.util.List;

import ilayda.core.utilities.result.*;
import ilayda.entities.concretes.Position;



public interface PositionService {


	DataResult<List<Position>> getAll();
	Result add(Position position);

}
