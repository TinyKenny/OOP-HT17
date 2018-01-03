import java.util.ArrayList;

public class IdrottsSystem {
	
	private Input in = new Input();
	private ArrayList<Event> eventList = new ArrayList<>();
	
	private Event findEvent(String eventName) {
		for (int i = 0; i < eventList.size(); i++) {
			System.out.println(eventList.get(i).getEventName());
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
	
	private void addEvent() {
		String eventName;
		while (true) {
			System.out.print("Event name: ");
			String enteredEventName = in.readTrimmedString();
			if (enteredEventName.isEmpty()) {
				System.out.println("Error: name can't be empty");
				continue;
			}
			eventName = normalizeName(enteredEventName);
			break;
		}
		System.out.println(eventName);
		if(findEvent(eventName) != null) {
			System.out.println("Error: "+eventName+" has already been added.");
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
		
	}
	
	
	private boolean handleCommand(String enteredCommand) {
		switch (enteredCommand.toLowerCase()){
		case "help":
			System.out.println("HELP");
			return true;
		case "add event":
			addEvent();
			return true;
		case "add participant":
			System.out.println("LÄGG TILL DELTAGARE");
			return true;
		case "remove participant":
			System.out.println("TA BORT DELTAGARE");
			return true;
		case "add result":
			System.out.println("REGISTRERA RESULTAT");
			return true;
		case "participant":
			System.out.println("RESULTATLISTA FÖR DELTAGARE");
			return true;
		case "grennamn":
			System.out.println("RESULTATLISTA FÖR GREN");
			return true;
		case "message":
			System.out.println("MEDDELANDE");
			return true;
		case "exit":
			System.out.println("Exiting.");
			return false;
		default:
			System.out.println("Error: unknown command \"" + enteredCommand + "\"");
			return true;
		}
	}
	
	public void run() {
		boolean continueRunning;
		do {
			System.out.println("MAKE THIS ENGLISH! GRENNAMN!!!!");
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
