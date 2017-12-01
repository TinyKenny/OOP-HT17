package hundar;

import java.util.ArrayList;
import java.util.Scanner;

public class DogKennel {
	
	private static Dog dogNameSearch(Scanner scan, ArrayList<Dog> dogList){
		String dogToFind = scan.nextLine();
		for(Dog d: dogList) {
			if (d.getName().equalsIgnoreCase(dogToFind)) {
			
		}
		}	
	}

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		ArrayList<Dog> dogList = new ArrayList<>();
		
		String enteredCommand;
		do {
			System.out.print("Skriv in ett kommando: ");
			enteredCommand = scan.nextLine();
			
			switch (enteredCommand.toLowerCase()) {
			case "reg":
			case "registrera":
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
				dogList.add(new Dog(dogName, dogRace, dogAge, dogWeight));
				System.out.println(String.format("Du har registrerat hunden %s, %s, %d år, %d kg.", dogName, dogRace, dogAge, dogWeight));
				break;
			case "öka":
			case "öka ålder":
				System.out.print("Ange namnet på hunden som ska åldras: ");
				String dogToAgeName = scan.nextLine();
				
				boolean dogFound = false;
				
				for(Dog d: dogList) {
					if(d.getName().equalsIgnoreCase(dogToAgeName)){
						System.out.println(String.format("%s är nu ett år äldre", dogToAgeName));
						d.increaseAge();
						dogFound = true;
					}
				}
				
				if(!dogFound) {
					System.out.println("Den här hunden är inte registrerad");
				}
				
				break;
			case "lis":
			case "lista":
				System.out.println("se uppgiftsbeskrivningen");
				break;
			case "ta":
			case "ta bort":
				System.out.println("Vilken hund ska tas bort? ");
				String removeDogName = scan.nextLine();
				
				
				
				System.out.println("fixa så att man kan ta bort hundar.");
				break;
			case "qq":
			case "avs":
			case "avsluta":
				System.out.println("Avslutar...");
			}
			
		} while (!(enteredCommand.equalsIgnoreCase("qq") || enteredCommand.equalsIgnoreCase("avs") || enteredCommand.equalsIgnoreCase("avsluta")));
		
	}
	
	
	
}
