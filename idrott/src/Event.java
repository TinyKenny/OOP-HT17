//Jonathan Rawet (jora0374), Viktor Fagerström Eriksson (vier5348), Hanna Severien (hase8853)
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
	
	public void removeResult(Result resultToRemove) {
		results.remove(resultToRemove);
	}
	
	public void printResults() {
		if (results.isEmpty()) {
			System.out.println("Error: no results for " + eventName + " found");
		}
		int placement = 1;
		float currentResultValue;
		float previousResultValue = 0.0f;
		String participantName;
		String participantTeam;
		sortResults();
		System.out.println("Results for " + eventName);
		for (int i = 0; i < results.size(); i++) {
			currentResultValue = results.get(i).getGreatestAttempt();
			participantName = results.get(i).getParticipantName();
			participantTeam = results.get(i).getParticipantTeam();
			if (previousResultValue > currentResultValue) {
				placement = i + 1;
			}
			previousResultValue = currentResultValue;
			System.out.printf("%d %f %s %s\n", placement, currentResultValue, participantName, participantTeam);
		}
	}
	
	private void sortResults() {
		for (int i = 1; i < results.size(); i++) {
			moveUpUntillSorted(i);
		}
	}
	
	private void moveUpUntillSorted(int i) {
		while (i > 0 && results.get(i).compareTo(results.get(i-1))) {
			swapResultPositions (i, i-1);
			i--;
			
		}
	}
	
	private void swapResultPositions(int originIndex, int targetIndex) {
		Result resultToMove = results.remove(originIndex);
		results.add(targetIndex, resultToMove);
	}
	
	
}
