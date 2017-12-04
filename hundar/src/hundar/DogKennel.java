package hundar;

import java.util.ArrayList;
import java.util.Scanner;

public class DogKennel {
	
	private Scanner scan = new Scanner(System.in);
	private ArrayList<Dog> dogList = new ArrayList<>();
	
	private void registerNewDog() {
		System.out.print("Ange hundens namn: ");
		String dogName = scan.nextLine();
		System.out.print("Ange hundens ras: ");
		String dogRace = scan.nextLine();
		System.out.print("Ange hundens ålder: ");
		int dogAge = scan.nextInt();
		scan.nextLine();
		System.out.print("Ange hundens vikt (i kg): ");
		int dogWeight = scan.nextInt();
		scan.nextLine();
		Dog dogToAdd = new Dog(dogName, dogRace, dogAge, dogWeight);
		dogList.add(dogToAdd);
		System.out.println("Du har lagt till: " + dogToAdd);
	}
	
	private int findDogByName(){
		String dogToFindName = scan.nextLine();
		for (int i = 0; i < dogList.size(); i++) {
			if (dogList.get(i).getName().equalsIgnoreCase(dogToFindName)) {
				return i;
			}
		}
		System.out.println("Ingen hund med det angivna namnet hittades.");
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
		float minimumTailLength = scan.nextFloat();
		scan.nextLine();
		boolean foundAnyDog = false;
		for (Dog dog: dogList) {
			if (dog.getTailLength() >= minimumTailLength) {
				System.out.println(dog);
				foundAnyDog = true;
			}
		}
		if (!foundAnyDog) {
			System.out.println(String.format("Ingen hund med en svanslängd på, eller över, %f hittades.", minimumTailLength));
		}
	}
	
	private void removeDog() {
		System.out.print("Ange namnet på hunden som ska tas bort: ");
		int indexOfDogToRemove = findDogByName();
		if (indexOfDogToRemove >= 0) {
			dogList.remove(indexOfDogToRemove);
		}
	}

	public boolean handleCommand(String enteredCommand) {
		switch (enteredCommand.toLowerCase()) {
			case "reg":
			case "registrera":
			case "register new dog":
				registerNewDog();
				return true;
			case "öka":
			case "öka ålder":
			case "increase age":
				ageDog();
				return true;
			case "lis":
			case "lista":
			case "list dogs":
				listDogs();
				return true;
			case "ta":
			case "ta bort":
			case "remove dog":
				removeDog();
				return true;
			case "qq":
			case "avs":
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
			String command = scan.nextLine();
			continueRunning = handleCommand(command);
		} while(continueRunning);
	}
	
	public static void main(String[] args) {
		DogKennel kennel = new DogKennel();
		kennel.run();
	}
}
