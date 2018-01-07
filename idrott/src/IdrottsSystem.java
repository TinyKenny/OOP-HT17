import java.util.ArrayList;

public class IdrottsSystem {
	
	private static final int MESSAGE_BOX_WIDTH = 60;
	private static final int MESSAGE_MAX_LENGTH = 56;
	
	private Input in = new Input();
	private ArrayList<Event> eventList = new ArrayList<>();
	private ArrayList<Participant> participantList = new ArrayList<>();
	private int nextParticipantNumber = 100;
	
	private Event findEvent(String eventName) {
		eventName = normalizeName(eventName);
		for (int i = 0; i < eventList.size(); i++) {
			if (eventList.get(i).getEventName().equals(eventName)) {
				return eventList.get(i);
			}
		}
		return null;
	}
	
	private String normalizeName(String name) {
		String firstChar = name.substring(0, 1).toUpperCase();
		String nameCapitalized = firstChar + name.substring(1).toLowerCase();
		return nameCapitalized;
	}
	
	private String readName(String promptText) {
		while(true) {
			System.out.print(promptText);
			String enteredName = in.readTrimmedString();
			if(enteredName.isEmpty()) {
				System.out.println("Error: name can't be empty");
				continue;
			}
			return normalizeName(enteredName);
		}
	}
	
	private Participant findParticipantName(String participantName) {
		for (int i = 0; i < participantList.size(); i++) {
			if(participantList.get(i).getName().equals(participantName)) {
				return participantList.get(i);
			}
		}
		return null;
	}
	
	private Participant findParticipantNumber() {
		System.out.print("Number: ");
		int participantNumber = in.readInt();
		for (int i = 0; i < participantList.size(); i++) {
			if(participantList.get(i).getParticipantNumber() == participantNumber) {
				return participantList.get(i);
			}
		}
		System.out.println("Error: no participant with number " + participantNumber + " found!");
		return null;
	}
	
	private void addEvent() {
		String eventName = readName("Event name: ");
		if(findEvent(eventName) != null) {
			System.out.println("Error: " + eventName + " has already been added.");
			return;
		}
		
		System.out.print("Attempts allowed: ");
		int attemptsAllowed = in.readInt();
		while (attemptsAllowed < 1) {
			System.out.print("Error: too low, must allow at least one attempt: ");
			attemptsAllowed = in.readInt();
		}
		eventList.add(new Event(eventName, attemptsAllowed));
		System.out.println(eventName + " added.");
	}
	
	private void addParticipant() {
		String firstName = readName("First name: ");
		String lastName = readName("Last name: ");
		String teamName = readName("Team: ");
		
		if(findParticipantName(firstName + " " + lastName) != null) {
			System.out.println("Error: " + firstName + " " + lastName + " has already been added");
			return;
		}
		
		participantList.add(new Participant(firstName + " " + lastName, teamName, nextParticipantNumber));
		
		System.out.println(firstName + " " + lastName + " from " + teamName + " with number " + nextParticipantNumber);
		nextParticipantNumber++;
	}
	
	private void removeParticipant() {
		Participant participantToRemove = findParticipantNumber();
		if (participantToRemove != null) {
			String participantToRemoveName = participantToRemove.getName();
			String participantToRemoveTeam = participantToRemove.getTeamName();
			int participantToRemoveNumber = participantToRemove.getParticipantNumber();
			System.out.println(String.format("%s from %s with number %d removed\n", participantToRemoveName, participantToRemoveTeam, participantToRemoveNumber));
		}
	}
	
	private void addResult() {
		Participant participantToAddResult = findParticipantNumber();
		if (participantToAddResult == null) {
			return;
		}
		System.out.print("Event: ");
		String eventName = in.readTrimmedString();
		String normalizedEventName = normalizeName(eventName);
		Event eventForResults = findEvent(normalizedEventName);
		if (eventForResults == null) {
			System.out.println("Error: no event called \"" + eventName + "\" found!");
			return;
		}
		participantToAddResult.addResult(in, eventForResults);
	}
	
	private void printParticipantResults() {
		Participant participantToPrintResults = findParticipantNumber();
		if (participantToPrintResults == null) {
			return;
		}
		participantToPrintResults.printResults();
	}
	
	private String prepareMessage(String message) {
		if (message.length() > MESSAGE_MAX_LENGTH) {
			message = message.substring(0, MESSAGE_MAX_LENGTH);
		}
		return message.toUpperCase();
	}

	private void printMessage(String message) {
		
		String preparedMessage = prepareMessage(message);
		
		System.out.println(new String(new char[MESSAGE_BOX_WIDTH]).replace("\0", "#"));
		System.out.print("# ");
		System.out.print(new String(new char[MESSAGE_MAX_LENGTH]).replace("\0", " "));
		System.out.println(" #");
		System.out.print("# ");
		System.out.print(preparedMessage);
		System.out.print(new String(new char[MESSAGE_MAX_LENGTH-preparedMessage.length()]).replace("\0", " "));
		System.out.println(" #");
		System.out.print("# ");
		System.out.print(new String(new char[MESSAGE_MAX_LENGTH]).replace("\0", " "));
		System.out.println(" #");
		System.out.println(new String(new char[MESSAGE_BOX_WIDTH]).replace("\0", "#"));
	}
	
	private boolean handleCommand(String enteredCommand) {
		switch (enteredCommand.toLowerCase()){
		case "add event":
			addEvent();
			return true;
		case "add participant":
			addParticipant();
			return true;
		case "remove participant":
			removeParticipant();
			return true;
		case "add result":
			addResult();
			return true;
		case "participant":
			printParticipantResults();
			return true;
		case "exit":
			System.out.println("Exiting.");
			return false;
		default:
			if (enteredCommand.toLowerCase().startsWith("message ")) {
				printMessage(enteredCommand.substring("message ".length()));
				return true;
			}
			
			if (!enteredCommand.isEmpty()) {
				Event eventForResults = findEvent(enteredCommand);
				if (eventForResults != null) {
					eventForResults.printResults();
					return true;
				}
			}
			
			System.out.println("Error: unknown command \"" + enteredCommand + "\"");
			return true;
		}
	}
	
	public void run() {
		boolean continueRunning;
		do {
			System.out.print("Command> ");
			String command = in.readString().toLowerCase();
			continueRunning = handleCommand(command);
		} while(continueRunning);
	}
	
	public static void main(String[] args) {
		IdrottsSystem idrott1 = new IdrottsSystem();
		idrott1.run();
	}
	
}
