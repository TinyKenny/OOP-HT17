import java.util.ArrayList;

public class Participant {
	
	private String firstName;
	private String lastName;
	private String teamName;
	private int participantNumber;
	private ArrayList<Result> results = new ArrayList<>();
	
	public Participant(String firstName, String lastName, String teamName, int participantNumber) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.teamName = teamName;
		this.participantNumber = participantNumber;
	}
	
	public String getName() {
		return firstName + " " + lastName;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
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
			System.out.println("Error: " + firstName + " " + lastName + " from " + teamName + " has already made " + eventForResults.getAttemptsAllowed() + " attempts in " + eventForResults.getEventName() + ".");;
			return;
		}
		
		float attemptResult;
		do {
			System.out.print("Results for " + firstName + " " + lastName + " from " + teamName + " in " + eventForResults.getEventName() + ": ");
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
