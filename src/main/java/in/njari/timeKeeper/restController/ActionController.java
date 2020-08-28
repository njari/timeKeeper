package in.njari.timeKeeper.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import in.njari.timeKeeper.entity.Action;
import in.njari.timeKeeper.service.ActionRepository;
import in.njari.timeKeeper.utility.JsonManipulator;

@Controller
@RequestMapping("/action")
public class ActionController {

	@Autowired
	private ActionRepository actionRepository;

	@GetMapping
	public ResponseEntity<List<Action>> fetchAllActivities() {
		return new ResponseEntity<List<Action>>(actionRepository.findAll(), HttpStatus.OK);

	}

	@PostMapping
	public ResponseEntity<Action> createNewaction(@RequestBody String actionJson) {
		Action action = JsonManipulator.createObjectInstance(actionJson, Action.class);
		if (action == null)
			return new ResponseEntity<Action>(HttpStatus.BAD_REQUEST);
		return new ResponseEntity<Action>(actionRepository.save(action), HttpStatus.CREATED);

	}

}
