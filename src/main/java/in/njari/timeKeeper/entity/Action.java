package in.njari.timeKeeper.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Action {

	public enum ActivityType {
		RESTING, PHYSICAL, MENTAL, OTHER;

	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private long id;
	@Column(name = "name")
	private String name;
	@Column(name = "activity_type")
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

	Action() {
	}

	public Action(ActivityType activityType, String name) {
		this.name = name;
		this.activityType = activityType;
	}

}
