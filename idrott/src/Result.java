
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
	
	public boolean compareTo(Result otherResult) {
		if (getGreatestAttempt() < otherResult.getGreatestAttempt()) {
			return true;
		}
		if (getGreatestAttempt() > otherResult.getGreatestAttempt()) {
			return false;
		}
		return compareParticipantNames(otherResult);
	}
	
	private boolean compareParticipantNames(Result otherResult) {
		String participantName = getParticipantName();
		int participantNameLength = participantName.length();
		String otherParticipantName = otherResult.getParticipantName();
		int otherParticipantNameLength = otherParticipantName.length();
		
		for (int i = 0; i < participantNameLength && i < otherParticipantNameLength; i++) {
			if (participantName.charAt(i) != otherParticipantName.charAt(i)) {
				return participantName.charAt(i) < otherParticipantName.charAt(i);
			}
		}
		return participantNameLength < otherParticipantNameLength;
	}
	
}
