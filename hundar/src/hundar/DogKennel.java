//Jonathan Rawet (jora0374), Viktor Fagerström Eriksson (vier5348), Hanna Severien (hase8853)
package hundar;

import java.util.ArrayList;

public class DogKennel {
	
	private Input in = new Input();
	private ArrayList<Dog> dogList = new ArrayList<>();
	
	private void registerNewDog() {
		System.out.print("Ange hundens namn: ");
		String dogName = in.readString();
		System.out.print("Ange hundens ras: ");
		String dogRace = in.readString();
		System.out.print("Ange hundens ålder: ");
		int dogAge = in.readInt();
		System.out.print("Ange hundens vikt (i kg): ");
		int dogWeight = in.readInt();
		Dog dogToAdd = new Dog(dogName, dogRace, dogAge, dogWeight);
		dogList.add(dogToAdd);
		System.out.println("Du har lagt till: " + dogToAdd);
	}
	
	private int findDogByName(){
		String dogToFindName = in.readString();
		for (int i = 0; i < dogList.size(); i++) {
			if (dogList.get(i).getName().equalsIgnoreCase(dogToFindName)) {
				return i;
			}
		}
		System.out.println("error: Ingen hund med det angivna namnet hittades.");
		return -1;
	}
	
	private void ageDog() {
		System.out.print("Ange namnet på hunden som ska åldras: ");
		int indexOfDogToAge = findDogByName();
		if (indexOfDogToAge >= 0) {
			dogList.get(indexOfDogToAge).increaseAge();
		}
	}
	
	private void listDogs() {
		System.out.print("Ange minimumsvanslängd för hundarna du vill visa: ");
		float minimumTailLength = in.readFloat();
		boolean foundAnyDog = false;
		for (Dog dog: dogList) {
			if (dog.getTailLength() >= minimumTailLength) {
				System.out.println(dog);
				foundAnyDog = true;
			}
		}
		if (!foundAnyDog) {
			System.out.println(String.format("error: Ingen hund med en svanslängd på, eller över, %f hittades.", minimumTailLength));
		}
	}
	
	private void removeDog() {
		System.out.print("Ange namnet på hunden som ska tas bort: ");
		int indexOfDogToRemove = findDogByName();
		if (indexOfDogToRemove >= 0) {
			Dog removedDog = dogList.remove(indexOfDogToRemove);
			System.out.println("Du tagit bort hunden: " + removedDog);
		}
	}

	private boolean handleCommand(String enteredCommand) {
		switch (enteredCommand.toLowerCase()) {
			case "registrera":
			case "register new dog":
				registerNewDog();
				return true;
			case "öka ålder":
			case "increase age":
				ageDog();
				return true;
			case "lista":
			case "list dogs":
				listDogs();
				return true;
			case "ta bort":
			case "remove dog":
				removeDog();
				return true;
			case "avsluta":
			case "exit":
				System.out.println("Avslutar...");
				return false;
			default:
				System.out.println("error: Ogiltigt kommando.");
				return true;
		}
	}
	
	public void run() {
		boolean continueRunning;
		do {
			System.out.print("Skriv in ett kommando: ");
			String command = in.readString();
			continueRunning = handleCommand(command);
		} while(continueRunning);
	}
	
	public static void main(String[] args) {
		DogKennel kennel = new DogKennel();
		kennel.run();
	}
}