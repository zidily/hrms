package ilayda.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ilayda.business.abstracts.PositionService;
import ilayda.core.utilities.result.*;
import ilayda.entities.concretes.Position;

@RestController
@RequestMapping("/api/positions")
public class PositionController {

	private PositionService positionService;
	
	@Autowired
	public PositionController(PositionService positionService) {
		super();
		this.positionService=positionService;
	}

	@PostMapping("/add")
	public Result add(@RequestBody Position position) {
		return this.positionService.add(position);
	}
	
	
	@GetMapping("/getall")
	public DataResult<List<Position>> getAll(){
		return this.positionService.getAll();
	}
}
