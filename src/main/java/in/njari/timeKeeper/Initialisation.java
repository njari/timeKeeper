package in.njari.timeKeeper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import in.njari.timeKeeper.entity.Activity;
import in.njari.timeKeeper.entity.Activity.ActivityType;
import in.njari.timeKeeper.service.ActivityRepository;

@Component
public class Initialisation implements CommandLineRunner {
	
	private static final Logger log = LoggerFactory.getLogger(ActivityRepository.class);
	
	@Autowired
	private ActivityRepository activityRepository;

	@Override
	public void run(String... args) throws Exception {
		log.info("Initialising Pomodoro ...");
		Activity pomodoro = new Activity(ActivityType.MENTAL, "Pomodoro" );
		log.info("pomodoro ::   {}" , pomodoro.getName());
		activityRepository.save(pomodoro);
	}
	
}


