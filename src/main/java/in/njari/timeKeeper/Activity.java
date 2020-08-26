package in.njari.timeKeeper;

public class Activity {

	public enum ActivityType {
		RESTING, PHYSICAL, MENTAL, OTHER;

	}

	private String name;
	private ActivityType type;

	public ActivityType getType() {
		return type;
	}

	public void setType(ActivityType type) {
		this.type = type;
	}

}
