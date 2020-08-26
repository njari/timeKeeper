package in.njari.timeKeeper;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import in.njari.timeKeeper.entity.Activity;
import in.njari.timeKeeper.entity.Activity.ActivityType;

@SpringBootApplication
public class TimeKeeperApplication {

	public static void main(String[] args) {
		SpringApplication.run(TimeKeeperApplication.class, args);
	}

}
