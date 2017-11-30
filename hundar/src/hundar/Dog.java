package hundar;

public class Dog {
	
	private String name;
	private int age;
	private int weight;
	
	public Dog(String name, int age, int weight) {
		this.name = name;
		this.age = age;
		this.weight = weight;
	}
	
	public void increaseAge() {
		this.age++;
	}
	
	
	
	
//	public float getTailLength() {
//		//TODO implement race check
//		float tailLength = (float) (age*weight)/10;
//		return tailLength;
//	}
//	
//	public String toString() {
//		return String.format("%s HUNDRAS %d år %d kg svans=%f", name, age, weight, getTailLength());
//	}
	
}
