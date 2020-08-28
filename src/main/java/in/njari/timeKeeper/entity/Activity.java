package in.njari.timeKeeper.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Activity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private long id;
	
	@ManyToOne
	private Action action ; 
	@Column(name = "duration")
	private int duration ;
	
	public Activity() {
		
	}
	
	public Activity(Action action , int duration) {
		this.action = action ;
		this.duration = duration;
	}
	
	public int getDuration() {
		return this.duration;
	}
	
	@Override
	public String toString() {
		return action.getName() + " for " + duration +" seconds.";
		
	}

}
