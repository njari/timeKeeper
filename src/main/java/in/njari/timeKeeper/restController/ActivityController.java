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

import in.njari.timeKeeper.entity.Activity;
import in.njari.timeKeeper.service.ActivityRepository;
import in.njari.timeKeeper.utility.JsonManipulator;

@Controller
@RequestMapping("/activity")
public class ActivityController {
	
	@Autowired
	private ActivityRepository activityRepository;
	
@GetMapping
public ResponseEntity<List<Activity>>fetchAllActivities() {
	return new ResponseEntity<List<Activity>>(activityRepository.findAll(), HttpStatus.OK);
		
}

@PostMapping
public ResponseEntity<Activity> createNewActivity(@RequestBody String activityJson) {
	Activity activity = JsonManipulator.createObjectInstance(activityJson, Activity.class);
	if (activity == null) 
		return new ResponseEntity<Activity>( HttpStatus.BAD_REQUEST) ;
	return new ResponseEntity<Activity>(activityRepository.save(activity), HttpStatus.CREATED) ;
	
}

	


}
