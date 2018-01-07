//Jonathan Rawet (jora0374), Viktor Fagerström Eriksson (vier5348), Hanna Severien (hase8853)
import java.util.ArrayList;

public class Participant {
	
	private String name;
	private String teamName;
	private int participantNumber;
	private ArrayList<Result> results = new ArrayList<>();
	
	public Participant(String name, String teamName, int participantNumber) {
		this.name = name;
		this.teamName = teamName;
		this.participantNumber = participantNumber;
	}
	
	public void prepareForRemoval() {
		for (int i = 0; i < results.size(); i++) {
			results.get(i).prepareForRemoval();
		}
	}
	
	public String getName() {
		return name;
	}
	
	public String getTeamName() {
		return teamName;
	}
	
	public int getParticipantNumber() {
		return participantNumber;
	}
	
	public void addResult(Input in, Event eventForResults) {
		Result resultObject = findResultForEvent(eventForResults);
		if (resultObject == null) {
			resultObject = new Result(this, eventForResults);
			results.add(resultObject);
		}
		if (!resultObject.hasAttemptsLeft()) {
			System.out.println("Error: " + name + " from " + teamName + " has already made " + eventForResults.getAttemptsAllowed() + " attempts in " + eventForResults.getEventName() + ".");
			return;
		}
		float attemptResult;
		do {
			System.out.print("Results for " + name + " from " + teamName + " in " + eventForResults.getEventName() + ": ");
			attemptResult = in.readFloat();
			if (attemptResult < 0.0) {
				System.out.println("Error: must be greater than or equal to zero!");
			}
		} while (attemptResult < 0.0);
		resultObject.addAttempt(attemptResult);
	}
	
	private Result findResultForEvent(Event eventForResults) {
		for (Result resultToCheck: results) {
			if (resultToCheck.isForEvent(eventForResults)) {
				return resultToCheck;
			}
		}
		return null;
	}
	
	public void printResults() {
		for (Result resultToPrint: results) {
			resultToPrint.printResult();
		}
	}
	
}
