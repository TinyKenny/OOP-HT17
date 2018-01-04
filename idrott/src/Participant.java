
public class Participant {
	
	private String name;
	private String teamName;
	private int participantNumber;
	
	public Participant(String name, String teamName, int participantNumber) {
		this.name = name;
		this.teamName = teamName;
	}
	
	public String getName() {
		return name;
	}
	
	public int getParticipantNumber() {
		return participantNumber;
	}
	
}
