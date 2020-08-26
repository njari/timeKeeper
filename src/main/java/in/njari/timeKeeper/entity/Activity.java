package in.njari.timeKeeper.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Activity {

	public enum ActivityType {
		RESTING, PHYSICAL, MENTAL, OTHER;

	}
	@Id
	@GeneratedValue
	private long id;
	private String name;
	private ActivityType activityType;

	public ActivityType getType() {
		return activityType;
	}

	public void setType(ActivityType type) {
		this.activityType = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	Activity() {
	}

	public Activity(ActivityType activityType, String name) {
		this.name = name;
		this.activityType = activityType;
	}

}
