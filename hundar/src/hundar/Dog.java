package hundar;

public class Dog {
	
	private String name;
	private String race;
	private int age;
	private int weight;
	
	public Dog(String name, String race, int age, int weight) {
		this.name = name;
		this.race = race;
		this.age = age;
		this.weight = weight;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void increaseAge() {
		this.age++;
	}
	
	public float getTailLength() {
		if (race.equalsIgnoreCase("tax") || race.equalsIgnoreCase("dachshund")) {
			return 3.7f;
		}
		return (float) ((age*weight)/10.0f);
	}
	
	
	@Override
	public String toString() {
		return String.format("%s %s %d år %d kg svans=%f", name, race, age, weight, getTailLength());
	}
}
