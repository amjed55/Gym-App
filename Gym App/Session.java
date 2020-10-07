import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Session {

	public double cost;
	public String date, time, duration, description, coach;
	
	public Session(String date, String time, String duration, String description, double cost, String coach) {
		this.date = date;
	        this.time = time;
		this.duration = duration;
		this.description = description;
		this.cost = cost;
		this.coach = coach;
		
        }

        public String getDate() {
		return date;
	}
	
	public String getTime() {
		return time;
	}
	
	public String getDuration() {
		return duration;
	}
	
	public String getDescription() {
		return description;
	}

	public double getCost() {
		return cost;
	}
	
	public String getCoach() {
		return coach;
	}
	
	
}