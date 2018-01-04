import java.util.ArrayList;

public class Event {
	
	private String eventName;
	private int attemptsAllowed;
	private ArrayList<Result> results = new ArrayList<>();
	
	public Event(String name, int attemptsAllowed) {
		eventName = name;
		this.attemptsAllowed = attemptsAllowed;
	}
	
	public String getEventName() {
		return eventName;
	}
	
	public int getAttemptsAllowed() {
		return attemptsAllowed;
	}
	
	
}
