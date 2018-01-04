
public class Result {
	
	private Participant performingParticipant;
	private Event relatedEvent;
	private int[] attemptResults;
	
	public Result(Participant performingParticipant, Event relatedEvent, int resultOfAttempt) {
		this.performingParticipant = performingParticipant;
		this.relatedEvent = relatedEvent;
		attemptResults = new int[relatedEvent.getAttemptsAllowed()];
	}
	
}
