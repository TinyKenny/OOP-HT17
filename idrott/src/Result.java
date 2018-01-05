
public class Result {
	
	private Participant performingParticipant;
	private Event relatedEvent;
	private float[] attemptResults;
	private int indexForNextAttempt = 0;
	
	public Result(Participant performingParticipant, Event relatedEvent) {
		this.performingParticipant = performingParticipant;
		this.relatedEvent = relatedEvent;
		attemptResults = new float[relatedEvent.getAttemptsAllowed()];
		relatedEvent.addResult(this);
	}
	
	public boolean isForEvent(Event eventToCheck) {
		return (relatedEvent == eventToCheck);
	}
	
	public boolean hasAttemptsLeft() {
		if (indexForNextAttempt == attemptResults.length) {
			return false;
		}
		return true;
	}
	
	public void addAttempt(float attemptResult) {
		attemptResults[indexForNextAttempt] = attemptResult;
		indexForNextAttempt++;
	}
	
	public void printResult() {
		System.out.print("Result for " + performingParticipant.getName() + " in " + relatedEvent.getEventName() + ": ");
		for (int i = 0; i < attemptResults.length; i++) {
			System.out.print(attemptResults[i]);
			if (i == attemptResults.length-1) {
				System.out.println("");
			} else {
				System.out.print(", ");
			}
		}
	}
	
	public String getResultString() {
		return "NOT IMPLEMENTED";
	}
	
	public float getGreatestAttempt() {
		float greatestAttempt = 0.0f;
		for (float attempt: attemptResults) {
			if (greatestAttempt < attempt) {
				greatestAttempt = attempt;
			}
		}
		return greatestAttempt;
	}
	
	public String getParticipantName() {
		return performingParticipant.getName();
	}
	
	public String getParticipantFirstName() {
		return performingParticipant.getFirstName();
	}
	
	public String getParticipantLastName() {
		return performingParticipant.getLastName();
	}
	
	public int compareTo(Result otherResult) {
		if (getGreatestAttempt() < otherResult.getGreatestAttempt()) {
			return -1;
		}
		if (getGreatestAttempt() > otherResult.getGreatestAttempt()) {
			return 1;
		}
		if (getGreatestAttempt() == otherResult.getGreatestAttempt()) {
			return -getParticipantName().replaceAll(" ", "").compareToIgnoreCase(otherResult.getParticipantName().replaceAll(" ", ""));
		}
		return 0;
	}
	
	private int compareParticipantFullNames(Result otherResult) {
		//Compare length of first names
		//Compare first names char by char
		//Compare length of last names
		//compare last names char by char
		return 0;
	}
	
}
