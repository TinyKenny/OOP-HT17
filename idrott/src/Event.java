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
	
	public void addResult(Result resultToAdd) {
		results.add(resultToAdd);
	}
	
	public void printResults() {
		sortResults();
		System.out.println("Results for " + eventName);
	}
	
	private void sortResults() {
		for (int i = 1; i < results.size(); i++) {
			moveUpUntillSorted(i);
		}
	}
	
	private void moveUpUntillSorted(int i) {
		while (i > 0 && results.get(i).getGreatestAttempt() < results.get(i-1).getGreatestAttempt()) {
			swapResultPositions (i, i-1);
			i--;
			
		}
	}
	
	private void swapResultPositions(int i1, int i2) {
		Result resultToMove = results.remove(i1);
		results.add(i2, resultToMove);
	}
	
	
}
