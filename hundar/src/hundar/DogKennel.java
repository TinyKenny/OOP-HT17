package hundar;

import java.util.ArrayList;
import java.util.Scanner;

public class DogKennel {

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
				System.out.println("implementera registrering av hund.");
				
				System.out.print("Ange hundens namn: ");
				String dogName = scan.nextLine();
				System.out.print("Ange hundens ålder: ");
				int dogAge = scan.nextInt();
				scan.nextLine();
				System.out.print("Ange hundens vikt (i kg): ");
				int dogWeight = scan.nextInt();
				scan.nextLine();
				dogList.add(new Dog(dogName, dogAge, dogWeight));
				break;
			case "öka":
			case "öka ålder":
				System.out.println("implementera val av hund.");
				break;
			case "lis":
			case "lista":
				System.out.println("se uppgiftsbeskrivningen");
				break;
			case "ta":
			case "ta bort":
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
