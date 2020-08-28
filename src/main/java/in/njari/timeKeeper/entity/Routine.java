package in.njari.timeKeeper.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.google.common.collect.ImmutableList;
@Entity
public class Routine {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@Column(name = "name")
	private String name;
	private int duration = 0 ;
	
	@ManyToMany
	private List<Activity> activitySet = new ArrayList<Activity>();
	
	public Routine(String name, List<Activity> activitySet) {
		this.name = name;
		this.activitySet = activitySet;
		for(int i = 0 ; i < activitySet.size() ; i++) {
			this.duration =+ activitySet.get(i).getDuration();
		}
	}

	public ImmutableList<Activity> getActivitySet() {
		return ImmutableList.copyOf(activitySet);
	}

	public void setActivitySet(List<Activity> activitySet) {
		this.activitySet = activitySet;
	}

	@Override
	public String toString() {
		String x = "Routine title : " + name + "\n";
	for (int i = 0 ; i < activitySet.size() ; i++) {
		x = x + activitySet.get(i).toString() + "\n";
	}
	return x;
}

	public int getDuration() {
		this.duration = 0 ;
		for(int i = 0 ; i < activitySet.size() ; i++) {
			this.duration =+ activitySet.get(i).getDuration();
		}
		return this.duration;
	}

	
}
