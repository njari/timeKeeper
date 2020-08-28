package in.njari.timeKeeper;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import in.njari.timeKeeper.entity.Action;
import in.njari.timeKeeper.entity.Action.ActivityType;
import in.njari.timeKeeper.entity.Activity;
import in.njari.timeKeeper.entity.Routine;
import in.njari.timeKeeper.service.ActionRepository;
import in.njari.timeKeeper.service.ActivityRepository;
import in.njari.timeKeeper.service.RoutineRepository;

@Component
public class Initialisation implements CommandLineRunner {

	private static final Logger log = LoggerFactory.getLogger(Initialisation.class);

	@Autowired
	private ActionRepository actionRepository;
	@Autowired
	private ActivityRepository activityRepository;
	@Autowired
	private RoutineRepository routineRepository;

	@Override
	public void run(String... args) throws Exception {
		log.info("Initialising Pomodoro ...");
		Action pomodoro = new Action(ActivityType.MENTAL, "Pomodoro");
		log.info("Action created ::   {}", pomodoro.getName());
		Action restTime = new Action(ActivityType.RESTING, "Take a break!");
		log.info("Action created ::   {}", restTime.getName());
		actionRepository.save(pomodoro);
		actionRepository.save(restTime);
		log.info(".................Creating a pomodoro routine................");
		Activity A1 = new Activity(pomodoro, 60);
		Activity A2 = new Activity(restTime, 60);
		activityRepository.save(A1);
		activityRepository.save(A2);
		List<Activity> activitySet = new ArrayList<Activity>();
		activitySet.add(A1);
		activitySet.add(A2);

		Routine firstRoutine = new Routine("Pomodoro Session", activitySet);
		routineRepository.save(firstRoutine);
		log.info("First routine created! --> ");
		log.info(firstRoutine.toString());

	}
}
